
val addressNoLens = Lens[Address, String](
  get = _.no,
  set = (o,v) => o.copy(no=v)
)

val a = Address(no="B-12", street="Monroe Street", city="Denver", state="CO", zip="803211")
addressNoLens.get(a) // return no.
addressNoLens.set(a, "B-56")

val cutAddressLens = Lens[Customer, Address](
  get = _.address,
  set = (o, v) => o.copy(address = v)
)

def compose[Outer, Inner, Value](
  outer: Lens[Outer, Inner], inner: Lens[Inner, Value]
) = Lens[Outer, Value](
  get = outer.get andThen inner.get,
  set = (obj, value) => outer.set(obj, inner.set(outer.get(obj), value) )
)

val a = Address(no="B-12", street="Monroe Street", city="Denver", state="CO", zip="803211")
val c = Customer(12, "john D Cook", a)

val custAddrNoLens = compose(custAddrNoLens, addressNoLens)
custAddrNoLens.get(c)
custAddrNoLens.set(c, "B-675")









