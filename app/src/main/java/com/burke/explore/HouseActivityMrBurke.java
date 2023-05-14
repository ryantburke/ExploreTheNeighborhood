package com.burke.explore;

public class HouseActivityMrBurke extends ExploreActivity{

    @Override
    protected void initializeHouse(){
        setContentView(R.layout.house_mrburke);
        houseLayout = findViewById(R.id.house_mrburke_layout);

        //initialize house and adjacent rooms
        Room[] rooms = new Room[18];
        //room                room name       array of connected rooms          button                            image                           description
        rooms[0]  = new Room("Entry Hallway",   new int[] {1,2,8,9},        findViewById(R.id.btn_entry_hallway),   R.drawable.rb_entry_hallway,"Time to explore the house! Where to go...");
        rooms[1]  = new Room("Street",          new int[] {0,2,17},         findViewById(R.id.btn_street),          R.drawable.rb_fourier,      "This family is gone, the house appears to be tidy. What comes next?");
        rooms[2]  = new Room("Garage",          new int[] {0,1},            findViewById(R.id.btn_garage),          R.drawable.rb_garage,       "The car is gone, perfect, we have time to explore!");
        rooms[3]  = new Room("Mystery Room",    new int[] {8},              findViewById(R.id.btn_bathroom),        R.drawable.rb_kitchen,      "Is that a chewy bar on the counter? Finders keepers!");
        rooms[4]  = new Room("Bedroom",         new int[] {8},              findViewById(R.id.btn_bedroom1),        R.drawable.rb_pantry,       "So many cans of tuna! Good thing I brought my can opener.");
        rooms[5]  = new Room("Bedroom",         new int[] {8},              findViewById(R.id.btn_bedroom2),        R.drawable.rb_living_room,  "Lets watch some Breaking Bad!");
        rooms[6]  = new Room("Drum Room",       new int[] {7,8},            findViewById(R.id.btn_drumroom),        R.drawable.rb_hallway,      "The light doesn't work, good! Looks like I won't get caught!");
        rooms[7]  = new Room("Graveyard",       new int[] {6,15},           findViewById(R.id.btn_graveyard),       R.drawable.rb_bunkroom,     "Cute pictures of kids, maybe I'll take a picture to take with me!");
        rooms[8]  = new Room("Hallway",         new int[] {0,3,4,5,6,14},   findViewById(R.id.btn_hallway),         R.drawable.rb_nursery,      "A baby! Guess I'm not alone here.");
        rooms[9]  = new Room("Living Room",     new int[] {0,14,10,12},     findViewById(R.id.btn_livingroom),      R.drawable.rb_master_bedroom,"Clean sheets! Maybe I'll take a nap.");
        rooms[10] = new Room("Man Cave",        new int[] {9,11},           findViewById(R.id.btn_mancave),         R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        rooms[11] = new Room("Woman Cave",      new int[] {10,12},          findViewById(R.id.btn_womancave),       R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        rooms[12] = new Room("Kitchen",         new int[] {9,11,13},        findViewById(R.id.btn_kitchen),         R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        rooms[13] = new Room("Side Yard",       new int[] {1,12,17},        findViewById(R.id.btn_sideyard),        R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        rooms[14] = new Room("La Piscina",      new int[] {8,9,15,16,17},   findViewById(R.id.btn_pool),            R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        rooms[15] = new Room("Fire Pit",        new int[] {7,14,16},        findViewById(R.id.btn_firepit),         R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        rooms[16] = new Room("Garden",          new int[] {14,15,17},       findViewById(R.id.btn_garden),          R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        rooms[17] = new Room("Outhouse",        new int[] {13,14,16},       findViewById(R.id.btn_outhouse),        R.drawable.rb_backyard,     "No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        house = new House("Mr. Burke's Mansion", rooms);
        currentRoom = house.getRooms()[0];
        homeownerRoom = house.getRooms()[0];

        //initialize text
        tvRoomName = findViewById(R.id.room_name);
        tvDescription = findViewById(R.id.room_description);
        ivMap = findViewById(R.id.iv_map);
        ivRoomImage = findViewById(R.id.iv_room_image);
        ivRoomImage.setImageResource(rooms[0].getImageID());

        //initialize characters
        character = findViewById(R.id.character);
        homeowner = findViewById(R.id.homeowner);

    }

}
