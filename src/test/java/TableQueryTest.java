
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.data.impl.TableValue;
import com.automationanywhere.botcommand.data.model.table.Row;
import com.automationanywhere.botcommand.samples.commands.basic.TableQuery;
import org.testng.annotations.Test;
import com.automationanywhere.botcommand.data.model.table.Table;
import com.automationanywhere.botcommand.data.model.Schema;
//import com.automationanywhere.botcore.api.dto.AttributeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableQueryTest {
    @Test
    public void teste(){
        TableQuery a = new TableQuery();

        TableValue tbv = new TableValue();
        Table searchResult = new Table();
        List<Schema> header = new ArrayList<Schema>();
        List<Row> rows = new ArrayList<Row>();
        List<Value> currentRow = new ArrayList<>();
        Row rw = new Row();

        //CRIA AS COLUNAS

        //new Schema("createdAt");

        //new Schema("id");
        Schema sc = new Schema();                                   //THE ERROR IS HERE
        //header.add(new Schema("TEST"));
        //searchResult.setSchema(header);

        //ADCIONA A LINHA
//        currentRow.add(new StringValue("COL1"));
//        currentRow.add(new StringValue("COL2"));
//        rw.setValues(currentRow);
//        rows.add(rw);
//        rows.add(rw);
//
//        searchResult.setRows(rows);
//
//        tbv.set(searchResult);
//
//        ListValue<String> values = a.action(tbv);

        //System.out.println("Expected First Value: " + values.get(1));
    }
}