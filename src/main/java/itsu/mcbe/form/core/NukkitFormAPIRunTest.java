package itsu.mcbe.form.core;

import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import itsu.mcbe.form.base.CustomForm;
import itsu.mcbe.form.base.ModalForm;
import itsu.mcbe.form.base.SimpleForm;
import itsu.mcbe.form.element.Button;
import itsu.mcbe.form.element.Dropdown;
import itsu.mcbe.form.element.Input;
import itsu.mcbe.form.element.Label;
import itsu.mcbe.form.element.Slider;
import itsu.mcbe.form.element.StepSlider;
import itsu.mcbe.form.element.Toggle;
import itsu.mcbe.form.event.NukkitFormEventListener;

public class NukkitFormAPIRunTest extends PluginBase {
	
	@Override
	public void onEnable() {
		getLogger().info("起動しました。");
		getServer().getPluginManager().registerEvents(new NukkitFormEventListener(), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equals("form")) {
			SimpleForm form = new SimpleForm()
					.setId(100)
					.setTitle("TITLE")
					.setContent("TEST_TEXT")
					.addButton(new Button("TESTBUTTON", "url", "") {
						@Override
						public void onClick() {
							sender.sendMessage("Clicked!: " + this.getText());
						}
					})
					.addButton(new Button("TESTBUTTON2", "url", "") {
						@Override
						public void onClick() {
							sender.sendMessage("Clicked!: " + this.getText());
						}
					});
			
			NukkitFormAPI.sendFormToPlayer((Player) sender, form);
			
		} else if(command.getName().equals("modalform")) {
			ModalForm form = new ModalForm() {
				
				@Override
				public void onButton1Click() {
					sender.sendMessage("Button1 clicked!");
				}
				
				@Override
				public void onButton2Click() {
					sender.sendMessage("Button2 clicked!");
				}
			}
			
			.setId(10101)
			.setTitle("ModalForm")
			.setContent("TestText")
			.setButton1Text("Button1")
			.setButton2Text("Button2");
			
			NukkitFormAPI.sendFormToPlayer((Player) sender, form);
			
		} else if(command.getName().equals("customform")) {
			CustomForm form = new CustomForm() {
				@Override
				public void onEnter(List<Object> response) {
					System.out.println(response);
				}
			}
					.setId(10123)
					.setTitle("CustomForm")
					
					.addFormElement(new Dropdown()
							.setText("Dropdown")
							.setDefaultOptionIndex(1)
							.addOption("A")
							.addOption("B")
							)
					
					.addFormElement(new Input()
							.setText("Input")
							.setPlaceHolder("PlaceHolder")
							.setDefaultText("AAAA")
							)
					
					.addFormElement(new Label()
							.setText("Label")
							)
					
					.addFormElement(new Slider()
							.setText("Slider")
							.setMin(0.0f)
							.setMax(100.0f)
							.setStep(20.0f)
							.setDefaultValue(20.0f)
							)
					
					.addFormElement(new StepSlider()
							.setText("StepSlider")
							.setDefaultIndex(2)
							.addStep("A")
							.addStep("B")
							.addStep("C")
							)
					
					.addFormElement(new Toggle()
							.setText("Toggle")
							.setValue(true)
							);
			
			NukkitFormAPI.sendFormToPlayer((Player) sender, form);
		}
		return true;
		
	}

}
