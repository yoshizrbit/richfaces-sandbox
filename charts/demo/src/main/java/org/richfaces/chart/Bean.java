package org.richfaces.chart;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.richfaces.sandbox.chart.model.ChartDataModel;
import org.richfaces.sandbox.chart.model.DateChartDataModel;
import org.richfaces.sandbox.chart.model.NumberChartDataModel;
import org.richfaces.sandbox.chart.model.StringChartDataModel;


@ManagedBean(name = "bean")
@RequestScoped
public class Bean implements Serializable {
    
    NumberChartDataModel a;
    NumberChartDataModel b;
    NumberChartDataModel c;
    NumberChartDataModel barModel;
    
    StringChartDataModel pie;
    StringChartDataModel category;
    StringChartDataModel category2;
    
    DateChartDataModel dateModel;
    
    List<Country> countries;
    
    NumberChartDataModel usaModel;
    
    
    
    @PostConstruct
    public void init(){
        a = new NumberChartDataModel(ChartDataModel.ChartType.line);
        a.put(1, 8);
        a.put(2, 12);
        a.put(3, 13);
        a.put(4, 14);
        a.put(5, 16);
        a.put(6, 18);
        a.put(7, 15);
        a.put(8, 20);
        a.put(9, 21);
        a.put(10, 15);
        a.put(12, 16);
        a.put(13, 18);
        a.put(14, 20);
        
        
        
        b = new NumberChartDataModel(ChartDataModel.ChartType.line);
        b.put(2, 6);
        b.put(3, 10);
        b.put(4, 11);
        b.put(5, 12);
        b.put(6, 15);
        b.put(7, 16);
        b.put(8, 14);
        b.put(9, 14);
        b.put(10, 14);
    
        barModel = new NumberChartDataModel(ChartDataModel.ChartType.bar);
        barModel.put(2,3);
        barModel.put(4,6);
        barModel.put(5,4);
        barModel.put(6,7);
        
        c = new NumberChartDataModel(ChartDataModel.ChartType.line);
        c.put(2, 6);
        c.put(3, 8);
        c.put(5, 4);
        c.put(10, 6);
        c.put(15, 8);
        c.put(14, 4);
    
        
        pie = new StringChartDataModel(ChartDataModel.ChartType.pie);
        pie.put("a", 3);
        pie.put("b", 4);
        pie.put("c", 5);
        
        category = new StringChartDataModel(ChartDataModel.ChartType.bar);
        category.put("A", 1);
        category.put("B", 2);
        category.put("C", 3);
        
        category2 = new StringChartDataModel(ChartDataModel.ChartType.bar);
        category2.put("A", 1);
        category2.put("B", 2);
        category2.put("C", 3);
        
        dateModel = new DateChartDataModel(ChartDataModel.ChartType.line);
        dateModel.put(new GregorianCalendar(2013, 4, 1).getTime(), 4);
        dateModel.put(new GregorianCalendar(2013, 4, 2).getTime(), 5);
        dateModel.put(new GregorianCalendar(2013, 4, 3).getTime(), 6);
        
        
        Country usa = new Country("USA");
        usa.put(1990,19.1);
        usa.put(1991,18.9);
        usa.put(1992,18.6);
        usa.put(1993,19.5);
        usa.put(1994,19.5);
        usa.put(1995,19.3);
        usa.put(1996,19.4);
        usa.put(1997,19.7);
        usa.put(1998,19.5);
        usa.put(1999,19.5);
        usa.put(2000,20.0);
        
        Country china = new Country("China");
        china.put(1990,2.2);
        china.put(1991,2.2);
        china.put(1992,2.3);
        china.put(1993,2.4);
        china.put(1994,2.6);
        china.put(1995,2.7);
        china.put(1996,2.8);
        china.put(1997,2.8);
        china.put(1998,2.7);
        china.put(1999,2.6);
        china.put(2000,2.7);
        
        
        Country japan = new Country("Japan");
        japan.put(1990, 9.4);
        japan.put(1991, 9.4);
        japan.put(1992, 9.5);
        japan.put(1993, 9.4);
        japan.put(1994, 9.9);
        japan.put(1995, 9.9);
        japan.put(1996, 10.1);
        japan.put(1997, 10.1);
        japan.put(1998, 9.7);
        japan.put(1999, 9.5);
        japan.put(2000, 9.7);
        
        Country russia = new Country("Russia");
        russia.put(1992,14);
        russia.put(1993,12.8);
        russia.put(1994,10.9);
        russia.put(1995,10.5);
        russia.put(1996,10.4);
        russia.put(1997,10);
        russia.put(1998,9.6);
        russia.put(1999,9.7);
        russia.put(2000,9.8);
        
                
        
        countries = new LinkedList<Country>();
        //countries.add(usa);
        countries.add(china);
        countries.add(japan);
        countries.add(russia);
        
        usaModel = new NumberChartDataModel(ChartDataModel.ChartType.line);
        usaModel.put(1990,19.1);
        usaModel.put(1991,18.9);
        usaModel.put(1992,18.6);
        usaModel.put(1993,19.5);
        usaModel.put(1994,19.5);
        usaModel.put(1995,19.3);
        usaModel.put(1996,19.4);
        usaModel.put(1997,19.7);
        usaModel.put(1998,19.5);
        usaModel.put(1999,19.5);
        usaModel.put(2000,20.0);
        
        
    }

    public NumberChartDataModel getA() {
        return a;
    }

    public NumberChartDataModel getB() {
        return b;
    }

    public NumberChartDataModel getC() {
        return c;
    }

    public StringChartDataModel getCategory() {
        return category;
    }

    public StringChartDataModel getCategory2() {
        return category2;
    }

    

    public NumberChartDataModel getBarModel() {
        return barModel;
    }

    public StringChartDataModel getPie() {
        return pie;
    }

    public DateChartDataModel getDateModel() {
        return dateModel;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public NumberChartDataModel getUsaModel() {
        return usaModel;
    }
    
    
    
    
    public class Country{
        private String name;
        //CO2 production year-> metric tons per capita
        private List<Record> data;
        
        public Country(String name){
            this.name = name;
            this.data = new LinkedList<Record>();
        }
        public void put(int year, double tons){
            this.data.add(new Record(year, tons));
        }
        
        public List getData() {
            return data;
        }

        public String getName() {
            return name;
        }
        
        public class Record{
            private int year;
            private double tons;

            public Record(int year, double tons) {
                this.year = year;
                this.tons = tons;
            }

            public double getTons() {
                return tons;
            }

            public int getYear() {
                return year;
            }
            
        }
                
        
    }
    
    
    
    
    
    

}
