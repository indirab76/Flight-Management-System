create table scheduledflight
  (
  scheduledid number(14)   primary key,
   sourceairport_code varchar2(20) not null,
  destinationairport_code varchar2(20) not null,
 arrivaltime date not null,
  departurtime date not null,
   availableseats number(4),
  ticketcost float(10),
  boardingdate date ,
   flightnumber number(14)  references flight(flightnumber) on delete cascade
);