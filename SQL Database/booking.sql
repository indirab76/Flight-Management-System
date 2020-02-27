create table booking
  (
   bookingid number(14) primary key ,
  userid number(14)  references users(userid) on delete cascade,
  bookingdate date,
 ticketcost float(10),
  flightnumber number(14) references flight(flightnumber) on delete cascade,
   noofpassengers number(10),
  scheduledid number(14) references scheduledflight(scheduledid) on delete cascade
  );
