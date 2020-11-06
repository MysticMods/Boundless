package com.mart.boundless.registry;

import com.mart.boundless.tile.CosmicInfuserTile;
import com.tterrag.registrate.util.entry.TileEntityEntry;

import static com.mart.boundless.Boundless.REGISTRATE;


public class ModTiles {

    public static final TileEntityEntry<CosmicInfuserTile> cosmic_infuser = REGISTRATE.tileEntity("cosmic_infuser", CosmicInfuserTile::new)
            .validBlock(ModBlocks.cosmic_infuser)
            .register();

    public static void setup() {

    }

}
