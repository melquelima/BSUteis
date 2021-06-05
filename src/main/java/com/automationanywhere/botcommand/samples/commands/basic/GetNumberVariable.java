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

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.samples.commands.utils.uteis;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.DataType;
import org.ini4j.Ini;

import static com.automationanywhere.commandsdk.model.AttributeType.BOOLEAN;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
//import MaskFormatter;


//import java.Math;
//import Math;

@BotCommand
@CommandPkg(label = "GetTextVariable",
        description = "", icon = "pkg.svg", name = "GetTextVariable")


public class GetTextVariable {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Key",description = "Key")
            String varName
    ) {

        uteis ut = new uteis();
        Ini ini = ut.getIniFile();

        //======================VALIDANDO SE JA EXISTE============
        if(!ut.variableExists(ini,varName)){
            throw new BotCommandException("Variavel nao encontrada!");
        }
        return new StringValue(ini.get(varName,"value"));

        //JOptionPane.showMessageDialog(null, pid, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}
