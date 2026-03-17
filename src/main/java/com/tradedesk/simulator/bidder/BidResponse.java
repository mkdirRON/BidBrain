package com.tradedesk.simulator.bidder;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public record BidResponse(UUID auctionID,
                          String bidderId,
                          Optional<Double> bidAmount,
                          Instant responseTimestamp
                          ) {

    /*
     * Creates a response where the bidder IS participating.
     * Handles the Instant.now() timestamp automatically.
     *
     * Usage: BidResponse.bid(auctionId, "Nike-US", 1.25)
     */
    public static BidResponse bid(UUID auctionID,String bidderId, double bidAmount){
        return new BidResponse(
                auctionID,
                bidderId,
                Optional.of(bidAmount),
                Instant.now()
        );
    }

    /*
     * Creates a response where the bidder is explicitly passing.
     * This is more expressive than trying to encode "no bid"
     * as a special number.
     *
     * Usage: BidResponse.pass(auctionId, "Nike-US")
     *
     */

    public static BidResponse pass(UUID auctionId, String bidderId) {

        return new BidResponse(
                auctionId,
                bidderId,
                Optional.empty(),
                Instant.now()
        );
    }
    // method hasBid() made for convenience and readability.
    // now instead of response.bidAmount.isPresent() its response.hasBid()
    public boolean hasBid(){
        return bidAmount.isPresent();
    }

    // same idea as hasBid method but with exception handling
    public double getAmount() {
        return bidAmount.orElseThrow(() ->
                new IllegalStateException(
                        "Tried to get bid amount from a pass response for bidder: " + bidderId
                )
        );
    }


}