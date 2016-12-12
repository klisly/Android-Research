## source
http://www.jianshu.com/p/0fa614784110
http://cloudtech.iteye.com/blog/1617583
onStartCommand返回字段说明

START_STICKY 
如果service进程被kill掉，保留service的状态为开始状态，
但不保留递送的intent对象。随后系统会尝试重新创建service，
由于服务状态为开始状态，所以创建服务后一定会调用onStartCommand(Intent,int,int)方法。
如果在此期间没有任何启动命令被传递到service，那么参数Intent将为null。

START_NOT_STICKY	
“非粘性的”。使用这个返回值时，如果在执行完onStartCommand后，
服务被异常kill掉，系统不会自动重启该服务。


START_REDELIVER_INTENT	
重传Intent。使用这个返回值时，如果在执行完onStartCommand后，
服务被异常kill掉，系统会自动重启该服务，并将Intent的值传入。

START_STICKY_COMPATIBILITY	
START_STICKY的兼容版本，但不保证服务被kill后一定能重启。

BIND_ABOVE_CLIENT
Added in API level 14
int BIND_ABOVE_CLIENT
认为该Service的重要程度比绑定的客户端还要重要。通常系统内存不足尝试kill app之前，
通常会先kill 其绑定的Service，但是如果设置了这个标志那么就不是这样的了
Flag for bindService(Intent, ServiceConnection, int): indicates that the client application binding 
to this service considers the service to be more important than the app itself. 
When set, the platform will try to have the out of memory killer kill the 
app before it kills the service it is bound to, though this is not guaranteed to be the case.

Constant Value: 8 (0x00000008)

BIND_ADJUST_WITH_ACTIVITY

Added in API level 14
int BIND_ADJUST_WITH_ACTIVITY
如果是由一个Activity绑定的，那么service的进程重要度将会升高，
不管这个Activity是否对用户可见，或者有其他的标志位被设置来降低进程的重要程度
Flag for bindService(Intent, ServiceConnection, int): If binding from an activity,
 allow the target service's process importance to be raised based on
  whether the activity is visible to the user, regardless whether
   another flag is used to reduce the amount that the client 
   process's overall importance is used to impact it.

Constant Value: 128 (0x00000080)

BIND_ALLOW_OOM_MANAGEMENT

Added in API level 14
int BIND_ALLOW_OOM_MANAGEMENT
Flag for bindService(Intent, ServiceConnection, int): allow the process 
hosting the bound service to go through its normal memory management. 
It will be treated more like a running service, allowing the system to 
(temporarily) expunge the process if low on memory or for some other 
whim it may have, and being more aggressive about making
 it a candidate to be killed (and restarted) if running for a long time.

Constant Value: 16 (0x00000010)

BIND_AUTO_CREATE

Added in API level 1
int BIND_AUTO_CREATE
Flag for bindService(Intent, ServiceConnection, int): automatically 
  create the service as long as the binding exists. Note that
  while this will create the service, its onStartCommand(Intent, int, int)
  method will still only be called due to an explicit call to startService(Intent). 
  Even without that, though, this still provides you with access to the service 
  object while the service is created.

Note that prior to ICE_CREAM_SANDWICH, not supplying this flag would also 
impact how important the system consider's the target service's process to be. 
When set, the only way for it to be raised was by binding from a service
 in which case it will only be important when that activity is in the foreground. 
 Now to achieve this behavior you must explicitly supply the new flag 
 BIND_ADJUST_WITH_ACTIVITY. For compatibility, old applications 
 that don't specify BIND_AUTO_CREATE will automatically have the 
 flags BIND_WAIVE_PRIORITY and BIND_ADJUST_WITH_ACTIVITY set for 
 them in order to achieve the same result.

Constant Value: 1 (0x00000001)

BIND_DEBUG_UNBIND

Added in API level 1
int BIND_DEBUG_UNBIND
Flag for bindService(Intent, ServiceConnection, int): include debugging 
help for mismatched calls to unbind. When this flag is set, 
the callstack of the following unbindService(ServiceConnection) call is
 retained, to be printed if a later incorrect unbind call is made. Note
  that doing this requires retaining information about the binding that
   was made for the lifetime of the app, resulting in a leak -- this should only be used for debugging.

Constant Value: 2 (0x00000002)

BIND_EXTERNAL_SERVICE

Added in API level 24
int BIND_EXTERNAL_SERVICE
Flag for bindService(Intent, ServiceConnection, int): The service being 
bound is an isolated, external service. This binds the service into the 
calling application's package, rather than the package in which the service is declared.

When using this flag, the code for the service being bound will execute
 under the calling application's package name and user ID. Because the 
 service must be an isolated process, it will not have direct access to 
 the application's data, though. The purpose of this flag is to allow 
 applications to provide services that are attributed to the app using 
 the service, rather than the application providing the service.

Constant Value: -2147483648 (0x80000000)

BIND_IMPORTANT

Added in API level 14
int BIND_IMPORTANT
当你的客户端在前台，这个标示符下的Service也变得重要性相当于前台的Activity，优先级迅速提升。
Flag for bindService(Intent, ServiceConnection, int): this service is 
very important to the client, so should be brought to the foreground
 process level when the client is. Normally a process can only be raised 
 to the visibility level by a client, even if that client is in the foreground.

Constant Value: 64 (0x00000040)

BIND_NOT_FOREGROUND

Added in API level 8
int BIND_NOT_FOREGROUND
你所绑定的Service优先级永远高不过前台Activity。
Flag for bindService(Intent, ServiceConnection, int): don't allow this 
binding to raise the target service's process to the foreground 
scheduling priority. It will still be raised to at least the same 
memory priority as the client (so that its process will not be killable
 in any situation where the client is not killable), but for CPU scheduling 
 purposes it may be left in the background. This only has an impact in the 
 situation where the binding client is a foreground process and the target 
 service is in a background process.

Constant Value: 4 (0x00000004)

BIND_WAIVE_PRIORITY

Added in API level 14
int BIND_WAIVE_PRIORITY
不影响Service的优先级，Service的管理像后台的应用进程的管理一样，依据后台LRU队列进行管理。
绑定的服务不可调整自身的优先级。
Flag for bindService(Intent, ServiceConnection, int): don't impact the
 scheduling or memory management priority of the target service's 
 hosting process. Allows the service's process to be managed on 
 the background LRU list just like a regular application process 
 in the background.

Constant Value: 32 (0x00000020)

1.BIND_ADJUST_WITH_ACTIVITY  Service的优先级将相对于其绑定的Activity，Activity到前台，则Service优先级相对提升，Activity到后台，则Servcie优先级相对降低。

2.BIND_ABOVE_CLIENT和BIND_IMPORTANT  
当你的客户端在前台，这个标示符下的Service也变得重要性相当于前台的Activity，优先级迅速提升。
若是BIND_ABOVE_CLIENT，则优先级已经超过了Activity，也就是说Activity要比Service先死，当资源不够的时候。

3.BIND_NOT_FOREGROUND 你所绑定的Service优先级永远高不过前台Activity。

4.BIND_WAIVE_PRIORITY 绑定的服务不可调整自身的优先级。


跨进程的通信方式, IPC的方式
Bundle
file
AIDL binder
Messenger 
ContentProvider
Socker

