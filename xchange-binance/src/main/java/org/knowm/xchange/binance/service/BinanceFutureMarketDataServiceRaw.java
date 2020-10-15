package org.knowm.xchange.binance.service;

import static org.knowm.xchange.binance.BinanceResilience.REQUEST_WEIGHT_RATE_LIMITER;

import java.io.IOException;
import java.util.List;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.BinanceFutureAuthenticated;
import org.knowm.xchange.binance.BinanceFutureExchange;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureFundingRate;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureMarkPrice;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.currency.CurrencyPair;

public class BinanceFutureMarketDataServiceRaw extends BinanceFutureBaseService {

  protected BinanceFutureMarketDataServiceRaw(
      BinanceFutureExchange exchange,
      BinanceFutureAuthenticated binance,
      ResilienceRegistries resilienceRegistries) {
    super(exchange, binance, resilienceRegistries);
  }

  public void ping() throws IOException {
    decorateApiCall(binance::ping)
        .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
        .call();
  }

  public List<BinanceFutureMarkPrice> getAllMarkPrices() throws IOException {
    return decorateApiCall(binance::markAllPrices)
        .withRetry(retry("markAllPrices"))
        .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
        .call();
  }
  
  public BinanceFutureMarkPrice getMarkPrice(CurrencyPair pair) throws IOException {
    return decorateApiCall(() -> binance.markPrice(BinanceAdapters.toSymbol(pair)))
        .withRetry(retry("markPrice"))
        .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
        .call();
  }
  
  public List<BinanceFutureFundingRate> getFundingRateHistory(CurrencyPair pair, 
      Long startTime, Long endTime, Integer limit) throws IOException {
    return decorateApiCall(() -> binance.fundingRate(
        BinanceAdapters.toSymbol(pair), startTime, endTime, limit))
        .withRetry(retry("fundingRate"))
        .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
        .call();
  }
  
}
