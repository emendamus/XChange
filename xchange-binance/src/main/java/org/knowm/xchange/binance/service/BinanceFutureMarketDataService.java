package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.BinanceFutureAuthenticated;
import org.knowm.xchange.binance.BinanceFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class BinanceFutureMarketDataService extends BinanceFutureMarketDataServiceRaw implements MarketDataService {
  
  public BinanceFutureMarketDataService(
      BinanceFutureExchange exchange,
      BinanceFutureAuthenticated binance, 
      ResilienceRegistries resilienceRegistries) {
    super(exchange, binance, resilienceRegistries);
  }

}
