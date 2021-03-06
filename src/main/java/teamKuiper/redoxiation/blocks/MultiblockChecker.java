package teamKuiper.redoxiation.blocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;

//THIS CODE IS USELESS, JUST FOR REFERENCE
public class MultiblockChecker {

	
	public static boolean checkMultiBlockWithABlock(World world, int xPos, int yPos, int zPos, int xMinus, int yMinus, int zMinus, int xPlus, int yPlus, int zPlus, Block block) {
		for(int x = xPos - xMinus; x <= xPos + xPlus; x++) {
			for(int y = yPos - yMinus; y <= yPos + yPlus; y++) {
				for(int z = zPos - zMinus; z <= zPos + zPlus; z++) {
					if(world.getBlock(x, y, z) != block) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static boolean checkMultiBlockWithBlocks(World world, int xPos, int yPos, int zPos, int xMinus, int yMinus, int zMinus, Block[][][] blocks) {
		int xPlus = blocks.length - xMinus - 1;
		int yPlus = blocks[0].length - yMinus - 1;
		int zPlus = blocks[0][0].length - zMinus - 1;
		//all Index
		for(int x = 0; x <= xPlus + xMinus; x++) {
			for(int y = 0; y <= yPlus + yMinus; y++) {
				for(int z = 0; z <= zPlus + zMinus; z++) {
					//check Block
					if(world.getBlock(xPos - xMinus + x, yPos - yMinus + y, zPos - zMinus + z) != blocks[x][y][z]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}