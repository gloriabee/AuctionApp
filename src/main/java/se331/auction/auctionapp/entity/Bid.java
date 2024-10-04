package se331.auction.auctionapp.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Transactional
@Data
@NoArgsConstructor
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double amount;
    LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name="auction_item_id")
    private AuctionItem item;


}
