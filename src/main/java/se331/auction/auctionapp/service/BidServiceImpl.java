package se331.auction.auctionapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.auction.auctionapp.entity.Bid;
import se331.auction.auctionapp.repository.BidRepository;
@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    final BidRepository bidRepository;
    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }
}
