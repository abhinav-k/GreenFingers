package com.example.greenfingers;

public class GardenName {
	 int _id;
	 String _name;
	 String _plant;
	 String _type;
	    
	     
	    // Empty constructor
	    public GardenName(){
	         
	    }
	    // constructor
	    public GardenName(int id, String name,String type,String plant){
	    	this._id = id;
	    	this._plant = plant;
	    	this._name = name;
	        this._type = type;
	    }
	     
	    // constructor
	    public GardenName(String name,String type,String plant){

	    	this._plant = plant;
	    	this._name = name;
	        this._type = type;
	    }
	    // getting ID
	    public int getID(){
	        return this._id;
	    }
	     
	    // setting id
	    public void setID(int id){
	        this._id = id;
	    }
	     
	    // getting name
	    public String getName(){
	        return this._name;
	    }
	     
	    // setting name
	    public void setName(String name){
	        this._name = name;
	    }
	    public String getType(){
	        return this._type;
	    }
	     
	    // setting name
	    public void setType(String name){
	        this._type = name;
	    }
	    public String getPlant(){
	       return this._plant;
	    }
	     
	    // setting name
	    public void setPlant(String name){
	        this._plant = name;
	    }
	     
	    
}
