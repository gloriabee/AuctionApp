package se331.auction.auctionapp.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.auction.auctionapp.entity.AuctionItem;
import se331.auction.auctionapp.entity.Bid;
import se331.auction.auctionapp.repository.AuctionItemRepository;
import se331.auction.auctionapp.repository.BidRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class initApp implements ApplicationListener<ApplicationReadyEvent>{
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        AuctionItem item1,item2,item3,item4,item5;

        item1 = auctionItemRepository.save(AuctionItem.builder()
                .description("Food")
                .type("Type A")
                .build());

        item2 = auctionItemRepository.save(AuctionItem.builder()
                .description("Shoes")
                .type("Type B")
                .build());

        item3 = auctionItemRepository.save(AuctionItem.builder()
                .description("Vintage")
                .type("Type C")
                .build());

        item4 = auctionItemRepository.save(AuctionItem.builder()
                .description("Paintings")
                .type("Type D")
                .build());

        item5 = auctionItemRepository.save(AuctionItem.builder()
                .description("art")
                .type("Type E")
                .build());

        Bid bid1 = bidRepository.save(Bid.builder().amount(100.0).dateTime(LocalDateTime.now()).item(item1).build());
        Bid bid2 = bidRepository.save(Bid.builder().amount(150.0).dateTime(LocalDateTime.now()).item(item1).build());
        Bid bid3 = bidRepository.save(Bid.builder().amount(200.0).dateTime(LocalDateTime.now()).item(item1).build());
        List<Bid> bids1 = new ArrayList<>(List.of(bid1, bid2, bid3));
        item1.setBids(bids1);
        item1.setSuccessfulBid(bid3);

        Bid bid4 = bidRepository.save(Bid.builder().amount(110.0).dateTime(LocalDateTime.now()).item(item2).build());
        Bid bid5 = bidRepository.save(Bid.builder().amount(160.0).dateTime(LocalDateTime.now()).item(item2).build());
        Bid bid6 = bidRepository.save(Bid.builder().amount(210.0).dateTime(LocalDateTime.now()).item(item2).build());
        List<Bid> bids2 = new ArrayList<>(List.of(bid4, bid5, bid6));
        item2.setBids(bids2);
        item2.setSuccessfulBid(bid6);

        Bid bid7 = bidRepository.save(Bid.builder().amount(120.0).dateTime(LocalDateTime.now()).item(item3).build());
        Bid bid8 = bidRepository.save(Bid.builder().amount(170.0).dateTime(LocalDateTime.now()).item(item3).build());
        Bid bid9 = bidRepository.save(Bid.builder().amount(220.0).dateTime(LocalDateTime.now()).item(item3).build());
        List<Bid> bids3 = new ArrayList<>(List.of(bid7, bid8, bid9));
        item3.setBids(bids3);
        item3.setSuccessfulBid(bid9);

        Bid bid10 = bidRepository.save(Bid.builder().amount(130.0).dateTime(LocalDateTime.now()).item(item4).build());
        Bid bid11 = bidRepository.save(Bid.builder().amount(180.0).dateTime(LocalDateTime.now()).item(item4).build());
        Bid bid12 = bidRepository.save(Bid.builder().amount(230.0).dateTime(LocalDateTime.now()).item(item4).build());
        List<Bid> bids4 = new ArrayList<>(List.of(bid10, bid11, bid12));
        item4.setBids(bids4);


        Bid bid13 = bidRepository.save(Bid.builder().amount(140.0).dateTime(LocalDateTime.now()).item(item5).build());
        Bid bid14 = bidRepository.save(Bid.builder().amount(190.0).dateTime(LocalDateTime.now()).item(item5).build());
        Bid bid15 = bidRepository.save(Bid.builder().amount(240.0).dateTime(LocalDateTime.now()).item(item5).build());
        List<Bid> bids5 = new ArrayList<>(List.of(bid13, bid14, bid15));
        item5.setBids(bids5);

        auctionItemRepository.saveAll(List.of(item1, item2, item3, item4, item5));
    }
}
