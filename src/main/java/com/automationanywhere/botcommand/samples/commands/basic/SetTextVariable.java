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

import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.sun.jna.platform.win32.Kernel32;
import org.apache.commons.io.FileUtils;
import org.ini4j.Ini;

import java.io.File;
//import MaskFormatter;


//import java.Math;
//import Math;

@BotCommand
@CommandPkg(label = "AddTextVariable",
        description = "", icon = "pkg.svg", name = "AddTextVariable")


public class TextVariable {

    @Execute
    public void action() {
        //===============================INPUTS================
        String varName = "teste";
        String value = "meu texto aqui";
        boolean isConstant = true;


        Ini ini = this.getIniFile();

        try{
            //======================VALIDANDO SE JA EXISTE============

            if(this.variableExists(ini,"varname")){
                String type = ini.get("varname","type");
                String constant = ini.get("varname","constant",Integer);

                if(!constant) {
                    if (type != "text") {
                        throw new BotCommandException("Tipos incompativeis - tipo ->" + type);
                    }
                }else{
                    throw new BotCommandException("Esta variavel ja foi declarada como constante e nao pode ser alterada!");
                }
            }

            ini.put("varname","value","meu texto");
            ini.put("varname","type","text");
            ini.store();
        }
        catch (Exception e){
            throw new BotCommandException("Erro ao gravar variavel" + e.getMessage());
        }
        System.out.println(ini.get("asd","123"));

        //JOptionPane.showMessageDialog(null, pid, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
        
    }

    private Ini getIniFile(){

        int pid = Kernel32.INSTANCE.GetCurrentProcessId();
        String tempDir = System.getProperty("java.io.tmpdir") + "GlobalVars/";
        String fileName = tempDir + Integer.toString(pid) + "_global.ini";

        Ini ini;

        try{
            File iniFile = new File(fileName);
            return new Ini(iniFile);
        }
        catch (Exception e){
            throw new BotCommandException("Sessao nao iniciada!:" + e.getMessage());
        }
    }

    private boolean variableExists(Ini ini,String section){

        for (String sectionName: ini.keySet()) {
            if(section == sectionName){
                return true;
            }
        }
        return false;
    }


}
