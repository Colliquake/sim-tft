package units;

public interface Unit_Data_Sheet {
    String SHEET=
            "Ahri\t2\t600\t1080\t1944\t0\t60\t45\t81\t145.8\t20\t20\t660\t0.75\t0.25\tStarGuardian\tSorcerer\n" +
            "Annie\t2\t750\t1350\t2430\t70\t140\t40\t72\t129.6\t40\t35\t420\t0.65\t0.25\tMechPilot\tSorcerer\n" +
            "Ashe\t3\t600\t1080\t1944\t50\t100\t60\t108\t194.4\t20\t20\t1130\t0.8\t0.25\tCelestial\tSniper\n" +
            "AurelionSol\t5\t1100\t1980\t3564\t120\t120\t10\t18\t32.4\t55\t40\t180\t0.2\t0.25\tRebel\tStarship\n" +
            "Bard\t3\t700\t1260\t2268\t0\t90\t45\t81\t145.8\t30\t20\t660\t0.7\t0.25\tAstro\tMystic\n" +
            "Blitzcrank\t2\t650\t1170\t2106\t125\t125\t55\t99\t178.2\t45\t35\t180\t0.5\t0.25\tChrono\tBrawler\n" +
            "Caitlyn\t1\t500\t900\t1620\t0\t125\t45\t81\t145.8\t20\t20\t1130\t0.75\t0.25\tChrono\tSniper\n" +
            "Cassiopeia\t3\t750\t1350\t2430\t0\t25\t40\t72\t129.6\t30\t20\t420\t0.75\t0.25\tBattlecast\tMystic\n" +
            "Darius\t2\t750\t1350\t2430\t0\t60\t60\t108\t194.4\t40\t30\t180\t0.65\t0.25\tSpacePirate\tManaReaver\n" +
            "Ekko\t5\t850\t1530\t2754\t80\t150\t60\t108\t194.4\t30\t20\t180\t0.9\t0.25\tCybernetic\tInfiltrator\n" +
            "Ezreal\t3\t600\t1080\t1944\t50\t80\t60\t108\t194.4\t20\t20\t660\t0.75\t0.25\tChrono\tBlaster\n" +
            "Fiora\t1\t450\t810\t1458\t0\t85\t45\t81\t145.8\t30\t20\t180\t1\t0.25\tCybernetic\tBlademaster\n" +
            "Fizz\t4\t700\t1260\t2268\t50\t120\t60\t108\t194.4\t25\t20\t180\t0.85\t0.25\tMechPilot\tInfiltrator\n" +
            "Gangplank\t5\t1000\t1800\t3240\t70\t160\t60\t108\t194.4\t30\t20\t180\t1\t0.25\tSpacePirate\tMercenary\tDemolitionist\n" +
            "Gnar\t4\t750\t1350\t2430\t0\t120\t50\t90\t162\t45\t40\t420\t0.8\t0.25\tAstro\tBrawler\n" +
            "Graves\t1\t650\t1170\t2106\t50\t80\t55\t99\t178.2\t40\t30\t180\t0.55\t0.25\tSpacePirate\tBlaster\n" +
            "Illaoi\t1\t700\t1260\t2268\t40\t80\t45\t81\t145.8\t40\t30\t180\t0.7\t0.25\tBattlecast\tBrawler\n" +
            "Irelia\t4\t800\t1440\t2592\t0\t30\t70\t126\t226.8\t35\t20\t180\t0.85\t0.25\tCybernetic\tBlademaster\tManaReaver\n" +
            "Janna\t5\t750\t1350\t2430\t50\t130\t60\t108\t194.4\t25\t20\t890\t0.8\t0.25\tStarGuardian\tParagon\n" +
            "JarvanIV\t1\t650\t1170\t2106\t50\t100\t50\t90\t162\t45\t30\t180\t0.6\t0.25\tDarkStar\tProtector\n" +
            "Jayce\t3\t800\t1440\t2592\t0\t80\t60\t108\t194.4\t40\t30\t180\t0.7\t0.25\tSpacePirate\tVanguard\n" +
            "Jhin\t4\t600\t1080\t1944\t-\t-\t80\t144\t259.2\t20\t20\t1130\t0.85\t0.25\tDarkStar\tSniper\n" +
            "Jinx\t4\t600\t1080\t1944\t-\t-\t70\t126\t226.8\t20\t20\t660\t0.75\t0.25\tRebel\tBlaster\n" +
            "Karma\t3\t600\t1080\t1944\t75\t100\t50\t90\t162\t20\t20\t660\t0.65\t0.25\tDarkStar\tMystic\n" +
            "KogMaw\t2\t550\t990\t1782\t0\t30\t50\t90\t162\t25\t20\t660\t0.7\t0.25\tBattlecast\tBlaster\n" +
            "Leona\t1\t600\t1080\t1944\t50\t100\t50\t90\t162\t45\t30\t180\t0.55\t0.25\tCybernetic\tVanguard\n" +
            "Lucian\t2\t500\t900\t1620\t0\t35\t50\t90\t162\t25\t20\t890\t0.7\t0.25\tCybernetic\tBlaster\n" +
            "Lulu\t5\t800\t1440\t2592\t75\t150\t45\t81\t145.8\t25\t20\t660\t0.8\t0.25\tCelestial\tMystic\n" +
            "Malphite\t1\t700\t1260\t2268\t-\t-\t70\t126\t226.8\t35\t30\t180\t0.5\t0.25\tRebel\tBrawler\n" +
            "MasterYi\t3\t750\t1350\t2430\t0\t55\t55\t99\t178.2\t30\t20\t180\t0.8\t0.25\tRebel\tBlademaster\n" +
            "Mordekaiser\t2\t650\t1170\t2106\t0\t90\t55\t99\t178.2\t50\t35\t180\t0.6\t0.25\tDarkStar\tVanguard\n" +
            "Nautilus\t2\t750\t1350\t2430\t50\t120\t60\t108\t194.4\t50\t35\t180\t0.65\t0.25\tAstro\tVanguard\n" +
            "Neeko\t3\t800\t1440\t2592\t75\t150\t50\t90\t162\t45\t40\t420\t0.65\t0.25\tStarGuardian\tProtector\n" +
            "Nocturne\t1\t500\t900\t1620\t40\t80\t50\t90\t162\t20\t20\t180\t0.75\t0.25\tBattlecast\tInfiltrator\n" +
            "Poppy\t1\t650\t1170\t2106\t60\t100\t50\t90\t162\t45\t30\t180\t0.55\t0.25\tStarGuardian\tVanguard\n" +
            "Rakan\t2\t600\t1080\t1944\t50\t100\t45\t81\t145.8\t45\t35\t420\t0.7\t0.25\tCelestial\tProtector\n" +
            "Riven\t4\t800\t1440\t2592\t0\t25\t70\t126\t226.8\t35\t20\t180\t0.85\t0.25\tChrono\tBlademaster\n" +
            "Rumble\t3\t900\t1620\t2916\t0\t50\t50\t90\t162\t45\t40\t180\t0.7\t0.25\tMechPilot\tDemolitionist\n" +
            "Shaco\t3\t650\t1170\t2106\t30\t80\t75\t135\t243\t25\t20\t180\t0.8\t0.25\tDarkStar\tInfiltrator\n" +
            "Shen\t2\t800\t1440\t2592\t100\t150\t60\t108\t194.4\t45\t35\t180\t0.7\t0.25\tChrono\tBlademaster\n" +
            "Soraka\t4\t700\t1260\t2268\t50\t125\t45\t81\t145.8\t30\t20\t660\t0.75\t0.25\tStarGuardian\tMystic\n" +
            "Syndra\t3\t600\t1080\t1944\t0\t60\t45\t81\t145.8\t20\t20\t890\t0.7\t0.25\tStarGuardian\tSorcerer\n" +
            "Teemo\t4\t600\t1080\t1944\t0\t80\t45\t81\t145.8\t20\t20\t1130\t1\t0.25\tAstro\tSniper\n" +
            "Thresh\t5\t950\t1710\t3078\t50\t90\t50\t90\t162\t55\t40\t420\t0.95\t0.25\tChrono\tManaReaver\n" +
            "TwistedFate\t1\t550\t990\t1782\t0\t75\t45\t81\t145.8\t20\t20\t660\t0.7\t0.25\tChrono\tSorcerer\n" +
            "Urgot\t5\t950\t1710\t3078\t30\t100\t80\t144\t259.2\t30\t20\t660\t0.7\t0.25\tBattlecast\tProtector\n" +
            "Vayne\t3\t550\t990\t1782\t0\t50\t60\t108\t194.4\t20\t20\t1130\t0.8\t0.25\tCybernetic\tSniper\n" +
            "Vi\t3\t750\t1350\t2430\t70\t140\t60\t108\t194.4\t45\t40\t180\t0.65\t0.25\tCybernetic\tBrawler\n" +
            "Viktor\t4\t650\t1170\t2106\t0\t70\t45\t81\t145.8\t20\t25\t660\t0.75\t0.25\tBattlecast\tSorcerer\n" +
            "Wukong\t4\t950\t1710\t3078\t50\t150\t50\t90\t162\t55\t40\t180\t0.75\t0.25\tChrono\tVanguard\n" +
            "Xayah\t1\t500\t900\t1620\t0\t60\t50\t90\t162\t20\t20\t660\t0.8\t0.25\tCelestial\tBlademaster\n" +
            "Xerath\t5\t750\t1350\t2430\t30\t80\t60\t108\t194.4\t20\t20\t1130\t0.9\t0.25\tDarkStar\tSorcerer\n" +
            "XinZhao\t2\t650\t1170\t2106\t0\t60\t60\t108\t194.4\t45\t35\t180\t0.7\t0.25\tCelestial\tProtector\n" +
            "Yasuo\t2\t700\t1260\t2268\t0\t90\t50\t90\t162\t30\t20\t180\t0.75\t0.25\tRebel\tBlademaster\n" +
            "Zed\t2\t650\t1170\t2106\t-\t-\t55\t99\t178.2\t25\t20\t180\t0.75\t0.25\tRebel\tInfiltrator\n" +
            "Ziggs\t1\t500\t900\t1620\t0\t40\t40\t72\t129.6\t20\t20\t660\t0.7\t0.25\tRebel\tDemolitionist\n" +
            "Zoe\t1\t500\t900\t1620\t70\t100\t40\t72\t129.6\t20\t20\t660\t0.7\t0.25\tStarGuardian\tSorcerer";
}
