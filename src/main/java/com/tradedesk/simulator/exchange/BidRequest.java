package com.tradedesk.simulator.exchange;

import java.time.Instant;
import java.util.UUID;

/*
  BidRequest represents a single ad slot available for auction.
  It is broadcast from the AdExchange to every BidderActor simultaneously.
 */

public record BidRequest(UUID auctionID,
                         String adSlotType,
                         int estimatedAudience,
                         double floorPrice,
                         Instant requestTimestamp) {

    public static BidRequest create(String adSlotType, int estimatedAudience, double floorPrice) {
        return new BidRequest(
                UUID.randomUUID(),   // auto-generate unique ID
                adSlotType,
                estimatedAudience,
                floorPrice,
                Instant.now()        // auto-capture creation time
        );
    }

}