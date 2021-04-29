/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 *
 */
package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.TableValue;
import com.automationanywhere.botcommand.data.impl.RecordValue;
import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.table.Row;
import com.automationanywhere.botcommand.data.model.table.Table;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.LIST;
import static com.automationanywhere.commandsdk.model.AttributeType.TABLE;
//import MaskFormatter;

//import java.Math;
//import Math;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@BotCommand
@CommandPkg(label = "TableQuery",
        description = "Esta action formata converte uma para strings de insert (Mysql)", icon = "pkg.svg", name = "TableQuery",
        return_description = "", return_type = LIST, return_required = true)


public class TableQuery {

    @Execute
    public ListValue<String> action(
            @Idx(index = "1", type = TABLE)
            @Pkg(label = "Tabela")
            TableValue Table
    ) {
        ListValue<String> returnvalue = new ListValue<String>();

        Table tb = Table.get();
        List<Row> listRow = tb.getRows();
        List<Schema> listSchema = tb.getSchema();

        //System.out.println(listRow.get(0).getValues());
        for(Schema sc : listSchema){
            System.out.println(sc.getName());
        }

        String QrLine = "";
        for(Row rw : listRow){
            //System.out.println(rw.getValues());
        }

        return returnvalue;
    }
    

    

}
