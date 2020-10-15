package org.knowm.xchange.binance.service;

import static org.knowm.xchange.binance.BinanceResilience.*;

import java.io.IOException;
import java.util.List;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.BinanceFutureAuthenticated;
import org.knowm.xchange.binance.BinanceFutureExchange;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.trade.BinanceFuturePosition;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.currency.CurrencyPair;

public class BinanceFutureTradeServiceRaw extends BinanceFutureBaseService {

  protected BinanceFutureTradeServiceRaw(
      BinanceFutureExchange exchange,
      BinanceFutureAuthenticated binance,
      ResilienceRegistries resilienceRegistries) {
    super(exchange, binance, resilienceRegistries);
  }
  
  public List<BinanceFuturePosition> getOpenPositions()
      throws IOException, BinanceException {
    return decorateApiCall(
            () ->
                binance.positionRisk(
                    getRecvWindow(),
                    getTimestampFactory(),
                    super.apiKey,
                    super.signatureCreator))
        .withRetry(retry("positionRisk"))
        .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
        .call();
  }

  public List<BinanceFuturePosition> getOpenPositions(CurrencyPair pair)
      throws IOException, BinanceException {
    return decorateApiCall(
            () ->
                binance.positionRisk(
                    pair != null ? BinanceAdapters.toSymbol(pair) : null,
                    getRecvWindow(),
                    getTimestampFactory(),
                    super.apiKey,
                    super.signatureCreator))
        .withRetry(retry("positionRisk"))
        .withRateLimiter(rateLimiter(REQUEST_WEIGHT_RATE_LIMITER))
        .call();
  }
}
