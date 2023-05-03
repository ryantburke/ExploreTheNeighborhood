package com.burke.explore;

import com.burke.explore.House;
import com.burke.explore.Room;

public class HouseFactory{

    public static House[] getHouseList()
    {
        return new House[] {hauntedHouse(), hauntedGrounds()};
    }

    public static House hauntedHouse(){
        //create a new array of rooms
        Room[] rooms = new Room[11];
        //room                room name       array of connected rooms     description
        rooms[0]  = new Room("Entry Hallway",   new int[] {1,2},         "keys to your car, doofus.");
        rooms[1]  = new Room("Fourier",         new int[] {0,3,5,6},     "quarter-nude painting of my dad.");
        rooms[2]  = new Room("Garage",          new int[] {0,5},         "vintage hammer, its not useful.");
        rooms[3]  = new Room("Kitchen",         new int[] {4,1},         "apple pie? why though?");
        rooms[4]  = new Room("Pantry",          new int[] {3},           "prized recipe, now get to work.");
        rooms[5]  = new Room("Living Room",     new int[] {2,1,10},      "couch potato.");
        rooms[6]  = new Room("Cobwebb Hallway", new int[] {1,7,8,9,10},  "wicked broom, get sweeping!");
        rooms[7]  = new Room("Spooky Bunkroom", new int[] {6},           "curdled milk, drink up!");
        rooms[8]  = new Room("Nursery",         new int[] {6},           "bloody pacifier, dear lord!");
        rooms[9]  = new Room("Master Bedroom",  new int[] {6,8,10},      "bucket of crap, rejoice!");
        rooms[10] = new Room("Backyard",        new int[] {1,5,6,9},     "hidden baby, meow!");
        return new House("Haunted House", rooms);
    }

    public static House hauntedGrounds(){
        //create a new array of rooms
        Room[] rooms = new Room[12];
        //room                room name       array of connected rooms     treasure
        rooms[0]  = new Room("Button Room",         new int[] {1,7},       "bucket full of gold crap.");
        rooms[1]  = new Room("Feline Room",         new int[] {2,0},       "1000 beads from god-knows where.");
        rooms[2]  = new Room("Twisted Room",        new int[] {3,1},       "endless supply of heavenly treasures.");
        rooms[3]  = new Room("Tea Room",            new int[] {4,5,2},     "apple pie?");
        rooms[4]  = new Room("Bathroom",            new int[] {3},         "bucket full of brown crap.");
        rooms[5]  = new Room("Hallway to Heaven",   new int[] {3,9,6,10},  "white fluffy cotton clouds of candy.");
        rooms[6]  = new Room("Parlor",              new int[] {5,9,7},     "ultimate lounge technology");
        rooms[7]  = new Room("The Bucket",          new int[] {0,6,8},     "curdled milk, drink up!");
        rooms[8]  = new Room("Bathroom",            new int[] {7},         "bucket full of green crap.");
        rooms[9]  = new Room("The GROUNDS",         new int[] {5,6,11},    "a bloody doll with three eyeballs misisng???");
        rooms[10] = new Room("Drug-Free Zone",      new int[] {5},         "not enough drugs.");
        rooms[11] = new Room("The SHED",            new int[] {9},         "savage wolf-blood pellets for mom's salud.");
        return new House("Haunted Grounds", rooms);
    }



}