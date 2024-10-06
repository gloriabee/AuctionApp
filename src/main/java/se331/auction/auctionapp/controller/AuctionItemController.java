package se331.auction.auctionapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se331.auction.auctionapp.entity.AuctionItem;
import se331.auction.auctionapp.service.AuctionItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuctionItemController {
    final AuctionItemService auctionItemService;

    @GetMapping("/auctions")
    public List<AuctionItem> searchAuctionItems(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type
    ) {
        if(description!=null && type!=null) {
            return auctionItemService.getAuctionItemsByDescriptionAndType(description,type);
        }
        else if(description!=null) {
            return auctionItemService.getAuctionItemsByDescription(description);
        }
        else if(type!=null) {
            return auctionItemService.getAuctionItemsByType(type);
        }
        return auctionItemService.getAllAuctionItems(); // Example pagination
    }

//    @GetMapping("/auctions/description")
//    public List<AuctionItem> searchAuctionItemsByDescription(@RequestParam String description) {
//        return auctionItemService.getAuctionItemsByDescription(description);
//    }
//
//    @GetMapping("/auctions/successfulBid")
//    public List<AuctionItem> getAuctionItemsWithSuccessfulBidLessThan(@RequestParam Double maxBidValue){
//        return auctionItemService.getAuctionItemWithSuccessfulBidLessThan(maxBidValue);
//    }

}
