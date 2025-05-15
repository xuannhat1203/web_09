package com.baitap.session09.controller;
import com.baitap.session09.Service.TicketServiceImp;
import com.baitap.session09.modal.Seat;
import com.baitap.session09.modal.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TicketController {

    private TicketServiceImp ticketService = new TicketServiceImp();

    @GetMapping("/book/{scheduleId}")
    public String showBookingPage(@PathVariable("scheduleId") Long scheduleId, Model model) {
        // Giả sử đã có danh sách ghế từ DB
        List<Seat> seats = getSeatsBySchedule(scheduleId);
        model.addAttribute("seats", seats);
        model.addAttribute("scheduleId", scheduleId);
        return "bookingPage";
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam("scheduleId") Long scheduleId,
                             @RequestParam("customerId") Long customerId,
                             @RequestParam("seatIds") List<Long> seatIds,
                             Model model) {

        List<Seat> selectedSeats = getSeatsByIds(seatIds);
        double total = selectedSeats.stream().mapToDouble(Seat::getPrice).sum();

        Ticket ticket = new Ticket();
        ticket.setCustomerId(customerId);
        ticket.setScheduleId(scheduleId);
        ticket.setListSeat(selectedSeats);
        ticket.setTotalMoney(total);
        ticket.setCreatedAt(new Date());

        boolean success = ticketService.addTicket(ticket);
        model.addAttribute("success", success);
        model.addAttribute("total", total);
        return "bookingResult";
    }

    // Giả lập dữ liệu ghế
    private List<Seat> getSeatsBySchedule(Long scheduleId) {
        // TODO: Lấy từ DB
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            seats.add(new Seat((long) i, 1L, "A" + i, 50000.0, i % 3 == 0 ? "booked" : "available"));
        }
        return seats;
    }

    private List<Seat> getSeatsByIds(List<Long> ids) {
        List<Seat> all = getSeatsBySchedule(1L);
        List<Seat> result = new ArrayList<>();
        for (Seat s : all) {
            if (ids.contains(s.getId())) result.add(s);
        }
        return result;
    }
}

