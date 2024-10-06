package se331.auction.auctionapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import se331.auction.auctionapp.entity.AuctionItem;
import se331.auction.auctionapp.repository.AuctionItemRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {
    final AuctionItemRepository auctionItemRepository;


    @Override
    public List<AuctionItem> getAllAuctionItems() {
        return auctionItemRepository.findAll();
    }

    @Override
    public List<AuctionItem> getAuctionItemsByDescription(String description) {
        return auctionItemRepository.findByDescriptionContaining(description);
    }

    @Override
    public List<AuctionItem> getAuctionItemWithSuccessfulBidLessThan(Double maxBidValue) {
        return auctionItemRepository.findBySuccessfulBidAmountLessThan(maxBidValue);
    }
}
