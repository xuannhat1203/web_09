package com.baitap.session09.Service;

import com.baitap.session09.Dao.TicketDao;
import com.baitap.session09.Dao.TicketDaoImp;
import com.baitap.session09.modal.Ticket;

public class TicketServiceImp implements TicketService {
    public TicketDao ticketDao;
    public TicketServiceImp(){
        ticketDao = new TicketDaoImp();
    };
    @Override
    public boolean addTicket(Ticket ticket) {
        return false;
    }

    @Override
    public Long getLastTicketId() {
        return 0L;
    }

    @Override
    public boolean addTicketSeat(Long ticketId, Long seatId) {
        return false;
    }

    @Override
    public boolean updateSeatStatus(Long seatId, String status) {
        return false;
    }

    @Override
    public boolean updateAvailableSeats(Long scheduleId, int seatCount) {
        return false;
    }
}
