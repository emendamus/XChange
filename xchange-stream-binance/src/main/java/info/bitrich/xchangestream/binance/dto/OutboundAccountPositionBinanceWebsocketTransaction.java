package info.bitrich.xchangestream.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

public class OutboundAccountPositionBinanceWebsocketTransaction
    extends BaseBinanceWebSocketTransaction {

  private final long lastUpdateTimestamp;
  private final List<BinanceWebsocketBalance> balances;


  public OutboundAccountPositionBinanceWebsocketTransaction(
      @JsonProperty("e") String eventType,
      @JsonProperty("E") String eventTime,
      @JsonProperty("u") long lastUpdateTimestamp,
      @JsonProperty("B") List<BinanceWebsocketBalance> balances
  ) {
    super(eventType, eventTime);
    this.lastUpdateTimestamp = lastUpdateTimestamp;
    this.balances = balances;
  }


  public long getLastUpdateTimestamp() {
    return lastUpdateTimestamp;
  }

  public List<BinanceWebsocketBalance> getBalances() {
    return balances;
  }


  @Override
  public String toString() {
    return "OutboundAccountInfoBinanceWebsocketTransaction [ lastUpdateTimestamp="
        + lastUpdateTimestamp
        + ", balances="
        + balances
        + "]";
  }
}
