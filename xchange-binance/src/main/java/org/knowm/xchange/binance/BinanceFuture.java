package org.knowm.xchange.binance;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureFundingRate;
import org.knowm.xchange.binance.dto.marketdata.BinanceFutureMarkPrice;
import org.knowm.xchange.binance.dto.meta.BinanceTime;
import org.knowm.xchange.binance.dto.meta.exchangeinfo.BinanceExchangeInfo;

@Path("/fapi")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceFuture {

  @GET
  @Path("/v1/ping")
  /**
   * Test connectivity to the Rest API.
   *
   * @return
   * @throws IOException
   */
  Object ping() throws IOException;

  @GET
  @Path("/v1/time")
  /**
   * Test connectivity to the Rest API and get the current server time.
   *
   * @return
   * @throws IOException
   */
  BinanceTime time() throws IOException;
  
  @GET
  @Path("/v1/exchangeInfo")
  /**
   * Current future exchange trading rules and symbol information.
   *
   * @return
   * @throws IOException
   */
  BinanceExchangeInfo exchangeInfo() throws IOException;
  
  @GET
  @Path("/v1/premiumIndex")
  List<BinanceFutureMarkPrice> markAllPrices() throws IOException, BinanceException;
  
  @GET
  @Path("/v1/premiumIndex")
  BinanceFutureMarkPrice markPrice(@QueryParam("symbol") String symbol) throws IOException, BinanceException;
  
  @GET
  @Path("/v1/fundingRate")
  List<BinanceFutureFundingRate> fundingRate(@QueryParam("symbol") String symbol, 
      @QueryParam("startTime") Long startTime, @QueryParam("endTime") Long endTime, 
      @QueryParam("limit") Integer limit) throws IOException, BinanceException;
  
}
