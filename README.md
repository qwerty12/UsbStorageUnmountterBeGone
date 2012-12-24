USB OTG Unmount Wakelock Remover
================================

A conversion of jazzk's fix (http://forum.xda-developers.com/showthread.php?p=34939248) to Xposed.

On Samsung phones (from the Galaxy S2, to the Note 2, anyway), unmounting a plugged-in USB device through the convenient notification will leave your phone with a wakelock that will not go until you reboot.
This solves that by releasing the wakelock as soon as it's been created - the phone still unmounts your USB stick fine...

Licensed under the GPL v3, but if included in a project, proper credit is expected.
