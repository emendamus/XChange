package org.knowm.xchange.binance.service;

import org.knowm.xchange.binance.BinanceFutureAuthenticated;
import org.knowm.xchange.binance.BinanceFutureExchange;
import org.knowm.xchange.client.ResilienceRegistries;
import org.knowm.xchange.service.account.AccountService;

public class BinanceFutureAccountService extends BinanceFutureAccountServiceRaw
    implements AccountService {

  public BinanceFutureAccountService(
      BinanceFutureExchange exchange,
      BinanceFutureAuthenticated binance, 
      ResilienceRegistries resilienceRegistries) {
    super(exchange, binance, resilienceRegistries);
  }

}
