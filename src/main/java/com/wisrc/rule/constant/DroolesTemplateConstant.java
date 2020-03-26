package com.wisrc.rule.constant;

public class DroolesTemplateConstant {
    /**
     * 规则引擎模板
     *
     * @{ruleId} 规则编码
     * @{actionId} 事件ID
     * @{condition} 条件
     */
    public static final String DROOL_TPL = "import java.util.Map; " +
            "import com.wisrc.rule.util.DroolEntry; " +
            "" +
            "rule \"${ruleId}\"" +
            "    salience ${rulePriority}" +
            "    when" +
            "        $map:Map()" +
            "        $cond : Object(${condition});" +
            "    then" +
            "        DroolEntry.process($map, ${ruleId});" +
            "end";
}
