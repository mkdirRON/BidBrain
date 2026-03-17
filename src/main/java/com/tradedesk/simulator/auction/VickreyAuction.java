package com.tradedesk.simulator.auction;

import com.tradedesk.simulator.bidder.BidResponse;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VickreyAuction {

   public record AuctionResult(
            Optional<String> winnerId,   // who won (empty if no valid bids)
            double clearingPrice,         // what the winner pays
            double highestBid,            // the winner's actual bid (for logging)
            int totalBidders,             // how many actors responded
            int participatingBidders      // how many actually submitted a bid
    ) {

       public static AuctionResult noWinner(int totalBidders, int participating) {
           return new AuctionResult(Optional.empty(), 0.0, 0.0, totalBidders, participating);
       }

   }
}