package com.yong.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;


public class TimerTest {
    ActionListener listener=new TimerPrinter();
    Timer t =new Timer(1000,listener);




}


class TimerPrinter implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("the time is "+new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}