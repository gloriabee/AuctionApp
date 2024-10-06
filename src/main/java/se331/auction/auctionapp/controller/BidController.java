package se331.auction.auctionapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se331.auction.auctionapp.entity.Bid;
import se331.auction.auctionapp.service.BidService;
@Controller
@RequiredArgsConstructor
public class BidController {
    final BidService bidService;

    @PostMapping("/bid/create")
    public ResponseEntity<Bid> saveBid(@RequestBody Bid bid) {
        Bid savedBid=bidService.save(bid);
        return new ResponseEntity<>(savedBid, HttpStatus.OK);
    }

}
