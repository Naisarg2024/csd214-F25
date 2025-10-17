classDiagram
direction BT
class App {
  + run() void
  + addItem(SaleableItem) void
  - promptTicket() Ticket
  + editItem() void
  + editItem(Editable) void
  + getItem(SaleableItem) SaleableItem
  + listI(Object) void
  + sellItem() void
  + populate() void
  + addItem() void
  - printIndexedList(List~SaleableItem~) void
  + findItemExists(SaleableItem) boolean
  + deleteItem() void
  - parseIndex(String, int) int
  + findItem(SaleableItem) SaleableItem
  + listAny() void
}
class Book {
  + sellItem() void
  + equals(Object) boolean
  + toString() String
  + initialize() void
  + hashCode() int
  + edit() void
   String author
}
class CashTill {
  + sellITem(SaleableItem) void
  + showTotal() void
}
class DiscMag {
  + sellItem() void
  + initialize() void
  + edit() void
   boolean hasDisc
}
class Editable {
  + getInput(LocalDate) LocalDate
  + getInput(int) int
  + initialize() void
  + getInput(double) double
  + getInput(boolean) boolean
  + getInput(Enum) Enum
  + edit() void
   String input
}
class Magazine {
  + initialize() void
  + sellItem() void
  + edit() void
  + toString() String
   LocalDate currentIssue
   int orderQty
}
class Main {
  + main(String[]) void
}
class Publication {
  + toString() String
  + hashCode() int
  + equals(Object) boolean
   String description
   long id
   String title
   int copies
   long isbn
   double price
}
class SaleableItem {
<<Interface>>
  + sellItem() void
   double price
}
class Serializable {
<<Interface>>

}
class Ticket {
  + sellItem() void
  + toString() String
   String description
   long id
   double price
}
class Util {
  + getFakeDoubleBetween(int, int) double
  + getFakeIntegerBetween(int, int) int
   DiscMag fakeDiscMag
   Book fakeBook
   Ticket fakeTicket
   Magazine fakeMagazine
}

Book  -->  Publication 
DiscMag  -->  Magazine 
Magazine  -->  Publication 
Publication  -->  Editable 
Publication  ..>  SaleableItem 
Ticket  ..>  SaleableItem 
Ticket  ..>  Serializable 
