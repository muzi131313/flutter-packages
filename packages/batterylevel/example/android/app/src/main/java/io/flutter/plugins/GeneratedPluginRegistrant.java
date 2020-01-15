package io.flutter.plugins;

import io.flutter.plugin.common.PluginRegistry;
import com.hxflutter.batterylevel.BatterylevelPlugin;

/**
 * Generated file. Do not edit.
 */
public final class GeneratedPluginRegistrant {
  public static void registerWith(PluginRegistry registry) {
    if (alreadyRegisteredWith(registry)) {
      return;
    }
    BatterylevelPlugin.registerWith(registry.registrarFor("com.hxflutter.batterylevel.BatterylevelPlugin"));
  }

  private static boolean alreadyRegisteredWith(PluginRegistry registry) {
    final String key = GeneratedPluginRegistrant.class.getCanonicalName();
    if (registry.hasPlugin(key)) {
      return true;
    }
    registry.registrarFor(key);
    return false;
  }
}
