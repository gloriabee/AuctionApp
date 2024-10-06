package se331.auction.auctionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.auction.auctionapp.entity.AuctionItem;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem,Long> {
    List<AuctionItem> findByDescriptionContaining(String description);
    List<AuctionItem> findByTypeContaining(String type);
    List<AuctionItem> findBySuccessfulBidAmountLessThan(double maxBidValue);
    List<AuctionItem> findByDescriptionAndType(String description, String type);

}
