package com.baitap.session09.Service;

import com.baitap.session09.modal.Ticket;

public interface TicketService {
    boolean addTicket(Ticket ticket);
    public Long getLastTicketId();
    public boolean addTicketSeat(Long ticketId, Long seatId);
    public boolean updateSeatStatus(Long seatId, String status);
    public boolean updateAvailableSeats(Long scheduleId, int seatCount);
}
