/**
 * Task.java
 * Created on 11.02.2003, 16:39:13 Alex
 * Package: net.sf.memoranda
 * 
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda;

import java.util.Collection;
import java.util.Observable;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.ui.develop.StatusBarPanel;
import net.sf.memoranda.ui.develop.TopLabelPanel;

/**
 * 
 */
/*$Id: Task.java,v 1.9 2005/06/16 04:21:32 alexeya Exp $*/
public interface Task{
    
    public static final int SCHEDULED = 0;

    public static final int ACTIVE = 1;

    public static final int COMPLETED = 2;

    public static final int FROZEN = 4;

    public static final int FAILED = 5;
    
    public static final int LOCKED = 6;
    
    public static final int DEADLINE = 7;
    
    public static final int PRIORITY_LOWEST = 0;
    
    public static final int PRIORITY_LOW = 1;
    
    public static final int PRIORITY_NORMAL = 2;
    
    public static final int PRIORITY_HIGH = 3;
    
    public static final int PRIORITY_HIGHEST = 4;
    
    CalendarDate getStartDate();
    void setStartDate(CalendarDate date);

    CalendarDate getEndDate();
    void setEndDate(CalendarDate date);
    
    int getStatus(CalendarDate date);
    
    int getProgress();
    void setProgress(int p);
    
    int getPriority();
    void setPriority(int p);
    
    String getID();
    
    String getText();
    void setText(String s);
    
    int getActualLOC();
    void setActualLOC(int loc);
    
    int getActualTime();
    void setActualTime(double time);
    
    double getHoursEst();
    void setHoursEst(double hrs);
    
    double getHoursAct();
    void setHoursAct(double hrs);
    
    int getEstNumOfFiles();
    void setEstNumOfFiles(int files);
    
    int getActNumOfFiles();
    void setActNumOfFiles(int files);
    
    int getEstLOC();
    void setEstLOC(int loc);
    
    int getActLOC();
    void setActLOC(int loc);
    
    int getTaskTotalTime();
    
    /*Collection getDependsFrom();
    
    void addDependsFrom(Task task);
    
    void removeDependsFrom(Task task);*/
            
    Collection getSubTasks();    
    Task getSubTask(String id);
    
    boolean hasSubTasks(String id);
    
    void setEffort(long effort);
    long getEffort();
    
    void setDescription(String description);
    String getDescription();

    Task getParentTask();
    String getParentId();
    
    void freeze();
    void unfreeze();
	long getRate();
    
	void addObserver(TopLabelPanel tlpl, TopLabelPanel tlpr, StatusBarPanel sbp);
	void setChangeVal(int val);
	int getChangeVal();
	void setValue(Task task);
	
    nu.xom.Element getContent();
	String getPriorityString();

}
