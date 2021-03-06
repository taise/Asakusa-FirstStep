package teppeistudio.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import java.io.IOException;
import teppeistudio.modelgen.dmdl.model.JoinedSalesDetail;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>joined_sales_detail</code>を読み出す
 */
public final class JoinedSalesDetailInput implements ModelInput<JoinedSalesDetail> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public JoinedSalesDetailInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(JoinedSalesDetail model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getItemIdOption());
        parser.fill(model.getItemNameOption());
        parser.fill(model.getSalesIdOption());
        parser.fill(model.getSalesNumberOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}