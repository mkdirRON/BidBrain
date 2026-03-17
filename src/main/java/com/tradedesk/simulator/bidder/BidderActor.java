
package com.tradedesk.simulator.bidder;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.tradedesk.simulator.exchange.BidRequest;

/*
 * BidderActor represents a single advertising brand (e.g., Nike, Apple).
 * It is an autonomous, concurrent entity that:
 *   1. Receives BidRequests from the AdExchange
 *   2. Evaluates whether to bid based on budget and targeting criteria
 *   3. Calculates a bid using the expected value formula
 *   4. Sends a BidResponse back to the exchange
 */

