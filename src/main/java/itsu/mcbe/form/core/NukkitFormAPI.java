package itsu.mcbe.form.core;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.network.protocol.ModalFormRequestPacket;
import itsu.mcbe.form.base.Form;

public class NukkitFormAPI {

    private NukkitFormAPI() {}

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>NukkitFormAPI</h1>
     * <p>スレッドセーフにAPIを取得するメソッドです。
     * <br>
     *
     * @author itsu
     */
    public static NukkitFormAPI getSingleton() {
        return NukkitFormAPIFactory.instance;
    }
	
	/**
	 * <h1>NukkitFormAPI</h1>
	 * <small>For Nukkit / NukkitX / Jupiter</small>
	 * <br>
	 * <br>
	 * <h1>NukkitFormAPI</h1>
	 * <p>このAPIで作成したフォームを送信するメソッドです。ここ経由で送信するようにしてください。
	 * <br>
	 * 
	 * @author itsu
	 */
	public Form sendFormToPlayer(Player player, Form form) {
		form.build();
		form.encode();
		
		String json = form.getJson();
		
		ModalFormRequestPacket packet = new ModalFormRequestPacket();
		packet.data = json;
		packet.formId = form.getId();
		
		DataCenter.addForm(form.getId(), form);
		
		player.dataPacket(packet);
		
		return form;
	}

	private static final class NukkitFormAPIFactory {
        private static final NukkitFormAPI instance = new NukkitFormAPI();
    }

}
