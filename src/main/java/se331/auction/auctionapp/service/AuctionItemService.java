package se331.auction.auctionapp.service;

import org.springframework.data.domain.Page;
import se331.auction.auctionapp.entity.AuctionItem;

import java.util.List;

public interface AuctionItemService {
    List<AuctionItem> getAllAuctionItems();
    List<AuctionItem> getAuctionItemsByDescription(String description);
    List<AuctionItem> getAuctionItemsByType(String type);
    List<AuctionItem> getAuctionItemsByDescriptionAndType(String description, String type);
    List<AuctionItem> getAuctionItemWithSuccessfulBidLessThan(Double maxBidValue);
}
