package frontend

import com.raquo.laminar.api.L.{*, given}

def combatantItem(name: String): Element = li(p(name))
