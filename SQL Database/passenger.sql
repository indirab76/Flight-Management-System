 create table passenger
   (
   pnrnumber number(14)  primary key ,
   passengername varchar2(20) not null,
  passengerage number(3) not null,
  passengeruin number(12) not null,
 luggage float(126),
  bookingid number(14)  references booking(bookingid) on delete cascade
  );
