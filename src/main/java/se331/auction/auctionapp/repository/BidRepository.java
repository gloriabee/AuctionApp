package se331.auction.auctionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.auction.auctionapp.entity.Bid;

public interface BidRepository extends JpaRepository<Bid,Long> {
}
