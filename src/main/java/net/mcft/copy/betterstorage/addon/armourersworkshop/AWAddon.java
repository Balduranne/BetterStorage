package net.mcft.copy.betterstorage.addon.armourersworkshop;

import net.mcft.copy.betterstorage.addon.Addon;
import net.mcft.copy.betterstorage.api.stand.BetterStorageArmorStand;
import riskyken.armourersWorkshop.api.client.render.IEquipmentRenderHandler;
import riskyken.armourersWorkshop.api.common.equipment.EnumEquipmentType;
import riskyken.armourersWorkshop.api.common.equipment.IEquipmentDataHandler;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AWAddon extends Addon {
	
	public static IEquipmentDataHandler dataHandler;
	public static IEquipmentRenderHandler renderHandler;
	
	public static AWEquipmentHandler eqHandlerHead;
	public static AWEquipmentHandler eqHandlerChest;
	public static AWEquipmentHandler eqHandlerSkirt;
	public static AWEquipmentHandler eqHandlerLegs;
	public static AWEquipmentHandler eqHandlerFeet;
	
	public AWAddon() {
		super("armourersWorkshop");
	}
	
	@Override
	public void setupConfig() {
		
		FMLInterModComms.sendMessage("armourersWorkshop", "register", "net.mcft.copy.betterstorage.addon.armourersworkshop.AWDataManager");
		
		eqHandlerHead  = new AWEquipmentHandler(EnumEquipmentType.HEAD, 1);
		eqHandlerChest = new AWEquipmentHandler(EnumEquipmentType.CHEST, 1);
		eqHandlerSkirt = new AWEquipmentHandler(EnumEquipmentType.SKIRT, 2);
		eqHandlerLegs  = new AWEquipmentHandler(EnumEquipmentType.LEGS, 1);
		eqHandlerFeet  = new AWEquipmentHandler(EnumEquipmentType.FEET, 1);
		
		BetterStorageArmorStand.registerEquipHandler(eqHandlerHead);
		BetterStorageArmorStand.registerEquipHandler(eqHandlerChest);
		BetterStorageArmorStand.registerEquipHandler(eqHandlerSkirt);
		BetterStorageArmorStand.registerEquipHandler(eqHandlerLegs);
		BetterStorageArmorStand.registerEquipHandler(eqHandlerFeet);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers() {
		BetterStorageArmorStand.registerRenderHandler(new AWRenderHandler());
	}
	
}
