package se331.auction.auctionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.auction.auctionapp.entity.AuctionItem;

public interface AuctionItemRepository extends JpaRepository<AuctionItem,Long> {
}
