package net.katagaitai.phpscan.command;

import java.util.List;

import lombok.Value;
import net.katagaitai.phpscan.interpreter.Interpreter;
import net.katagaitai.phpscan.util.SymbolUtils;

import com.google.common.collect.Lists;

@Value
public class CallFunction implements Command {
	private String result;
	private String function;
	private List<String> argumentList;

	public String toString() {
		List<String> list = Lists.newArrayList();
		for (String argument : argumentList) {
			list.add(SymbolUtils.decodeSymbolString(argument));
		}
		return String.format("%s = %s(%s)", result, function, String.join(", ", list));
	}

	@Override
	public void accept(Interpreter vm) {
		vm.accept(this);
	}
}
