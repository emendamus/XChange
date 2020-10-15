package org.knowm.xchange.binance;

import static org.knowm.xchange.binance.Constants.*;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.binance.dto.account.BinanceFutureAccountInformation;
import org.knowm.xchange.binance.dto.trade.BinanceFuturePosition;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

@Path("/fapi")
@Produces(MediaType.APPLICATION_JSON)
public interface BinanceFutureAuthenticated extends BinanceFuture {
  
  @GET
  @Path("/v2/account")
  /**
   * Get current account information.
   *
   * @param recvWindow optional
   * @param timestamp
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  BinanceFutureAccountInformation account(
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("/v2/positionRisk")
  /**
   * Get current position information.<br>
   *
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceFuturePosition> positionRisk(
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

  @GET
  @Path("/v2/positionRisk")
  /**
   * Get current position information.<br>
   *
   * @param symbol
   * @param recvWindow optional
   * @param timestamp
   * @param apiKey
   * @param signature
   * @return
   * @throws IOException
   * @throws BinanceException
   */
  List<BinanceFuturePosition> positionRisk(
      @QueryParam("symbol") String symbol,
      @QueryParam("recvWindow") Long recvWindow,
      @QueryParam("timestamp") SynchronizedValueFactory<Long> timestamp,
      @HeaderParam(X_MBX_APIKEY) String apiKey,
      @QueryParam(SIGNATURE) ParamsDigest signature)
      throws IOException, BinanceException;

}
