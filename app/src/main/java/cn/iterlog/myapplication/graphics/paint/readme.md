Paint
public class Paint 
extends Object 

java.lang.Object
   ↳	android.graphics.Paint
Known Direct Subclasses
TextPaint

The Paint class holds the style and color information about how to draw geometries, text and bitmaps.

Summary
Nested classes
enum	Paint.Align
Align specifies how drawText aligns its text relative to the [x,y] coordinates. 
enum	Paint.Cap
The Cap specifies the treatment for the beginning and ending of stroked lines and paths. 
class	Paint.FontMetrics
Class that describes the various metrics for a font at a given text size. 
class	Paint.FontMetricsInt
Convenience method for callers that want to have FontMetrics values as integers. 
enum	Paint.Join
The Join specifies the treatment where lines and curve segments join on a stroked path. 
enum	Paint.Style
The Style specifies if the primitive being drawn is filled, stroked, or both (in the same color). 
Constants
int	ANTI_ALIAS_FLAG
Paint flag that enables antialiasing when drawing.
int	DEV_KERN_TEXT_FLAG
Legacy Paint flag, no longer used.
int	DITHER_FLAG
Paint flag that enables dithering when blitting.
int	EMBEDDED_BITMAP_TEXT_FLAG
Paint flag that enables the use of bitmap fonts when drawing text.
int	FAKE_BOLD_TEXT_FLAG
Paint flag that applies a synthetic bolding effect to drawn text.
int	FILTER_BITMAP_FLAG
Paint flag that enables bilinear sampling on scaled bitmaps.
int	HINTING_OFF
Font hinter option that disables font hinting.
int	HINTING_ON
Font hinter option that enables font hinting.
int	LINEAR_TEXT_FLAG
Paint flag that enables smooth linear scaling of text.
int	STRIKE_THRU_TEXT_FLAG
Paint flag that applies a strike-through decoration to drawn text.
int	SUBPIXEL_TEXT_FLAG
Paint flag that enables subpixel positioning of text.
int	UNDERLINE_TEXT_FLAG
Paint flag that applies an underline decoration to drawn text.
Public constructors
Paint()
Create a new paint with default settings.
Paint(int flags)
Create a new paint with the specified flags.
Paint(Paint paint)
Create a new paint, initialized with the attributes in the specified paint parameter.
Public methods
float	ascent()
Return the distance above (negative) the baseline (ascent) based on the current typeface and text size.
int	breakText(char[] text, int index, int count, float maxWidth, float[] measuredWidth)
Measure the text, stopping early if the measured width exceeds maxWidth.
int	breakText(String text, boolean measureForwards, float maxWidth, float[] measuredWidth)
Measure the text, stopping early if the measured width exceeds maxWidth.
int	breakText(CharSequence text, int start, int end, boolean measureForwards, float maxWidth, float[] measuredWidth)
Measure the text, stopping early if the measured width exceeds maxWidth.
void	clearShadowLayer()
Clear the shadow layer.
float	descent()
Return the distance below (positive) the baseline (descent) based on the current typeface and text size.
int	getAlpha()
Helper to getColor() that just returns the color's alpha value.
int	getColor()
Return the paint's color.
ColorFilter	getColorFilter()
Get the paint's colorfilter (maybe be null).
boolean	getFillPath(Path src, Path dst)
Applies any/all effects (patheffect, stroking) to src, returning the result in dst.
int	getFlags()
Return the paint's flags.
String	getFontFeatureSettings()
Returns the font feature settings.
float	getFontMetrics(Paint.FontMetrics metrics)
Return the font's recommended interline spacing, given the Paint's settings for typeface, textSize, etc.
Paint.FontMetrics	getFontMetrics()
Allocates a new FontMetrics object, and then calls getFontMetrics(fm) with it, returning the object.
int	getFontMetricsInt(Paint.FontMetricsInt fmi)
Return the font's interline spacing, given the Paint's settings for typeface, textSize, etc.
Paint.FontMetricsInt	getFontMetricsInt()
float	getFontSpacing()
Return the recommend line spacing based on the current typeface and text size.
int	getHinting()
Return the paint's hinting mode.
float	getLetterSpacing()
Return the paint's letter-spacing for text.
MaskFilter	getMaskFilter()
Get the paint's maskfilter object.
int	getOffsetForAdvance(char[] text, int start, int end, int contextStart, int contextEnd, boolean isRtl, float advance)
Get the character offset within the string whose position is closest to the specified horizontal position.
int	getOffsetForAdvance(CharSequence text, int start, int end, int contextStart, int contextEnd, boolean isRtl, float advance)
PathEffect	getPathEffect()
Get the paint's patheffect object.
Rasterizer	getRasterizer()
This method was deprecated in API level 21. Rasterizer is not supported by either the HW or PDF backends.
float	getRunAdvance(char[] text, int start, int end, int contextStart, int contextEnd, boolean isRtl, int offset)
Measure cursor position within a run of text.
float	getRunAdvance(CharSequence text, int start, int end, int contextStart, int contextEnd, boolean isRtl, int offset)
Shader	getShader()
Get the paint's shader object.
Paint.Cap	getStrokeCap()
Return the paint's Cap, controlling how the start and end of stroked lines and paths are treated.
Paint.Join	getStrokeJoin()
Return the paint's stroke join type.
float	getStrokeMiter()
Return the paint's stroke miter value.
float	getStrokeWidth()
Return the width for stroking.
Paint.Style	getStyle()
Return the paint's style, used for controlling how primitives' geometries are interpreted (except for drawBitmap, which always assumes FILL_STYLE).
Paint.Align	getTextAlign()
Return the paint's Align value for drawing text.
void	getTextBounds(String text, int start, int end, Rect bounds)
Return in bounds (allocated by the caller) the smallest rectangle that encloses all of the characters, with an implied origin at (0,0).
void	getTextBounds(char[] text, int index, int count, Rect bounds)
Return in bounds (allocated by the caller) the smallest rectangle that encloses all of the characters, with an implied origin at (0,0).
Locale	getTextLocale()
Get the text's primary Locale.
LocaleList	getTextLocales()
Get the text locale list.
void	getTextPath(char[] text, int index, int count, float x, float y, Path path)
Return the path (outline) for the specified text.
void	getTextPath(String text, int start, int end, float x, float y, Path path)
Return the path (outline) for the specified text.
float	getTextScaleX()
Return the paint's horizontal scale factor for text.
float	getTextSize()
Return the paint's text size.
float	getTextSkewX()
Return the paint's horizontal skew factor for text.
int	getTextWidths(char[] text, int index, int count, float[] widths)
Return the advance widths for the characters in the string.
int	getTextWidths(String text, float[] widths)
Return the advance widths for the characters in the string.
int	getTextWidths(String text, int start, int end, float[] widths)
Return the advance widths for the characters in the string.
int	getTextWidths(CharSequence text, int start, int end, float[] widths)
Return the advance widths for the characters in the string.
Typeface	getTypeface()
Get the paint's typeface object.
Xfermode	getXfermode()
Get the paint's xfermode object.
boolean	hasGlyph(String string)
Determine whether the typeface set on the paint has a glyph supporting the string.
final boolean	isAntiAlias()
Helper for getFlags(), returning true if ANTI_ALIAS_FLAG bit is set AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape.
final boolean	isDither()
Helper for getFlags(), returning true if DITHER_FLAG bit is set Dithering affects how colors that are higher precision than the device are down-sampled.
boolean	isElegantTextHeight()
Get the elegant metrics flag.
final boolean	isFakeBoldText()
Helper for getFlags(), returning true if FAKE_BOLD_TEXT_FLAG bit is set
final boolean	isFilterBitmap()
Whether or not the bitmap filter is activated.
final boolean	isLinearText()
Helper for getFlags(), returning true if LINEAR_TEXT_FLAG bit is set
final boolean	isStrikeThruText()
Helper for getFlags(), returning true if STRIKE_THRU_TEXT_FLAG bit is set
final boolean	isSubpixelText()
Helper for getFlags(), returning true if SUBPIXEL_TEXT_FLAG bit is set
final boolean	isUnderlineText()
Helper for getFlags(), returning true if UNDERLINE_TEXT_FLAG bit is set
float	measureText(char[] text, int index, int count)
Return the width of the text.
float	measureText(CharSequence text, int start, int end)
Return the width of the text.
float	measureText(String text, int start, int end)
Return the width of the text.
float	measureText(String text)
Return the width of the text.
void	reset()
Restores the paint to its default settings.
void	set(Paint src)
Copy the fields from src into this paint.
void	setARGB(int a, int r, int g, int b)
Helper to setColor(), that takes a,r,g,b and constructs the color int
void	setAlpha(int a)
Helper to setColor(), that only assigns the color's alpha value, leaving its r,g,b values unchanged.
void	setAntiAlias(boolean aa)
Helper for setFlags(), setting or clearing the ANTI_ALIAS_FLAG bit AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape.
void	setColor(int color)
Set the paint's color.
ColorFilter	setColorFilter(ColorFilter filter)
Set or clear the paint's colorfilter, returning the parameter.
void	setDither(boolean dither)
Helper for setFlags(), setting or clearing the DITHER_FLAG bit Dithering affects how colors that are higher precision than the device are down-sampled.
void	setElegantTextHeight(boolean elegant)
Set the paint's elegant height metrics flag.
void	setFakeBoldText(boolean fakeBoldText)
Helper for setFlags(), setting or clearing the FAKE_BOLD_TEXT_FLAG bit
void	setFilterBitmap(boolean filter)
Helper for setFlags(), setting or clearing the FILTER_BITMAP_FLAG bit.
void	setFlags(int flags)
Set the paint's flags.
void	setFontFeatureSettings(String settings)
Set font feature settings.
void	setHinting(int mode)
Set the paint's hinting mode.
void	setLetterSpacing(float letterSpacing)
Set the paint's letter-spacing for text.
void	setLinearText(boolean linearText)
Helper for setFlags(), setting or clearing the LINEAR_TEXT_FLAG bit
MaskFilter	setMaskFilter(MaskFilter maskfilter)
Set or clear the maskfilter object.
PathEffect	setPathEffect(PathEffect effect)
Set or clear the patheffect object.
Rasterizer	setRasterizer(Rasterizer rasterizer)
This method was deprecated in API level 21. Rasterizer is not supported by either the HW or PDF backends.
Shader	setShader(Shader shader)
Set or clear the shader object.
void	setShadowLayer(float radius, float dx, float dy, int shadowColor)
This draws a shadow layer below the main layer, with the specified offset and color, and blur radius.
void	setStrikeThruText(boolean strikeThruText)
Helper for setFlags(), setting or clearing the STRIKE_THRU_TEXT_FLAG bit
void	setStrokeCap(Paint.Cap cap)
Set the paint's Cap.
void	setStrokeJoin(Paint.Join join)
Set the paint's Join.
void	setStrokeMiter(float miter)
Set the paint's stroke miter value.
void	setStrokeWidth(float width)
Set the width for stroking.
void	setStyle(Paint.Style style)
Set the paint's style, used for controlling how primitives' geometries are interpreted (except for drawBitmap, which always assumes Fill).
void	setSubpixelText(boolean subpixelText)
Helper for setFlags(), setting or clearing the SUBPIXEL_TEXT_FLAG bit
void	setTextAlign(Paint.Align align)
Set the paint's text alignment.
void	setTextLocale(Locale locale)
Set the text locale list to a one-member list consisting of just the locale.
void	setTextLocales(LocaleList locales)
Set the text locale list.
void	setTextScaleX(float scaleX)
Set the paint's horizontal scale factor for text.
void	setTextSize(float textSize)
Set the paint's text size.
void	setTextSkewX(float skewX)
Set the paint's horizontal skew factor for text.
Typeface	setTypeface(Typeface typeface)
Set or clear the typeface object.
void	setUnderlineText(boolean underlineText)
Helper for setFlags(), setting or clearing the UNDERLINE_TEXT_FLAG bit
Xfermode	setXfermode(Xfermode xfermode)
Set or clear the xfermode object.
Inherited methods
From class java.lang.Object
Constants
ANTI_ALIAS_FLAG

Added in API level 1
int ANTI_ALIAS_FLAG
Paint flag that enables antialiasing when drawing.

Enabling this flag will cause all draw operations that support antialiasing to use it.

See also:

Paint(int)
setFlags(int)
Constant Value: 1 (0x00000001)

DEV_KERN_TEXT_FLAG

Added in API level 1
int DEV_KERN_TEXT_FLAG
Legacy Paint flag, no longer used.

Constant Value: 256 (0x00000100)

DITHER_FLAG

Added in API level 1
int DITHER_FLAG
Paint flag that enables dithering when blitting.

Enabling this flag applies a dither to any blit operation where the target's colour space is more constrained than the source.

See also:

Paint(int)
setFlags(int)
Constant Value: 4 (0x00000004)

EMBEDDED_BITMAP_TEXT_FLAG

Added in API level 19
int EMBEDDED_BITMAP_TEXT_FLAG
Paint flag that enables the use of bitmap fonts when drawing text.

Disabling this flag will prevent text draw operations from using embedded bitmap strikes in fonts, causing fonts with both scalable outlines and bitmap strikes to draw only the scalable outlines, and fonts with only bitmap strikes to not draw at all.

See also:

Paint(int)
setFlags(int)
Constant Value: 1024 (0x00000400)

FAKE_BOLD_TEXT_FLAG

Added in API level 1
int FAKE_BOLD_TEXT_FLAG
Paint flag that applies a synthetic bolding effect to drawn text.

Enabling this flag will cause text draw operations to apply a simulated bold effect when drawing a Typeface that is not already bold.

See also:

Paint(int)
setFlags(int)
Constant Value: 32 (0x00000020)

FILTER_BITMAP_FLAG

Added in API level 1
int FILTER_BITMAP_FLAG
Paint flag that enables bilinear sampling on scaled bitmaps.

If cleared, scaled bitmaps will be drawn with nearest neighbor sampling, likely resulting in artifacts. This should generally be on when drawing bitmaps, unless performance-bound (rendering to software canvas) or preferring pixelation artifacts to blurriness when scaling significantly.

If bitmaps are scaled for device density at creation time (as resource bitmaps often are) the filtering will already have been done.

See also:

Paint(int)
setFlags(int)
Constant Value: 2 (0x00000002)

HINTING_OFF

Added in API level 14
int HINTING_OFF
Font hinter option that disables font hinting.

See also:

setHinting(int)
Constant Value: 0 (0x00000000)

HINTING_ON

Added in API level 14
int HINTING_ON
Font hinter option that enables font hinting.

See also:

setHinting(int)
Constant Value: 1 (0x00000001)

LINEAR_TEXT_FLAG

Added in API level 1
int LINEAR_TEXT_FLAG
Paint flag that enables smooth linear scaling of text.

Enabling this flag does not actually scale text, but rather adjusts text draw operations to deal gracefully with smooth adjustment of scale. When this flag is enabled, font hinting is disabled to prevent shape deformation between scale factors, and glyph caching is disabled due to the large number of glyph images that will be generated.

SUBPIXEL_TEXT_FLAG should be used in conjunction with this flag to prevent glyph positions from snapping to whole pixel values as scale factor is adjusted.

See also:

Paint(int)
setFlags(int)
Constant Value: 64 (0x00000040)

STRIKE_THRU_TEXT_FLAG

Added in API level 1
int STRIKE_THRU_TEXT_FLAG
Paint flag that applies a strike-through decoration to drawn text.

See also:

Paint(int)
setFlags(int)
Constant Value: 16 (0x00000010)

SUBPIXEL_TEXT_FLAG

Added in API level 1
int SUBPIXEL_TEXT_FLAG
Paint flag that enables subpixel positioning of text.

Enabling this flag causes glyph advances to be computed with subpixel accuracy.

This can be used with LINEAR_TEXT_FLAG to prevent text from jittering during smooth scale transitions.

See also:

Paint(int)
setFlags(int)
Constant Value: 128 (0x00000080)

UNDERLINE_TEXT_FLAG

Added in API level 1
int UNDERLINE_TEXT_FLAG
Paint flag that applies an underline decoration to drawn text.

See also:

Paint(int)
setFlags(int)
Constant Value: 8 (0x00000008)

Public constructors
Paint

Added in API level 1
Paint ()
Create a new paint with default settings.

Paint

Added in API level 1
Paint (int flags)
Create a new paint with the specified flags. Use setFlags() to change these after the paint is created.

Parameters
flags	int: initial flag bits, as if they were passed via setFlags().
Paint

Added in API level 1
Paint (Paint paint)
Create a new paint, initialized with the attributes in the specified paint parameter.

Parameters
paint	Paint: Existing paint used to initialized the attributes of the new paint.
Public methods
ascent

Added in API level 1
float ascent ()
Return the distance above (negative) the baseline (ascent) based on the current typeface and text size.

Returns
float	the distance above (negative) the baseline (ascent) based on the current typeface and text size.
breakText

Added in API level 1
int breakText (char[] text, 
                int index, 
                int count, 
                float maxWidth, 
                float[] measuredWidth)
Measure the text, stopping early if the measured width exceeds maxWidth. Return the number of chars that were measured, and if measuredWidth is not null, return in it the actual width measured.

Parameters
text	char: The text to measure. Cannot be null.
index	int: The offset into text to begin measuring at
count	int: The number of maximum number of entries to measure. If count is negative, then the characters are measured in reverse order.
maxWidth	float: The maximum width to accumulate.
measuredWidth	float: Optional. If not null, returns the actual width measured.
Returns
int	The number of chars that were measured. Will always be <= abs(count).
breakText

Added in API level 1
int breakText (String text, 
                boolean measureForwards, 
                float maxWidth, 
                float[] measuredWidth)
Measure the text, stopping early if the measured width exceeds maxWidth. Return the number of chars that were measured, and if measuredWidth is not null, return in it the actual width measured.

Parameters
text	String: The text to measure. Cannot be null.
measureForwards	boolean: If true, measure forwards, starting with the first character in the string. Otherwise, measure backwards, starting with the last character in the string.
maxWidth	float: The maximum width to accumulate.
measuredWidth	float: Optional. If not null, returns the actual width measured.
Returns
int	The number of chars that were measured. Will always be <= abs(count).
breakText

Added in API level 1
int breakText (CharSequence text, 
                int start, 
                int end, 
                boolean measureForwards, 
                float maxWidth, 
                float[] measuredWidth)
Measure the text, stopping early if the measured width exceeds maxWidth. Return the number of chars that were measured, and if measuredWidth is not null, return in it the actual width measured.

Parameters
text	CharSequence: The text to measure. Cannot be null.
start	int: The offset into text to begin measuring at
end	int: The end of the text slice to measure.
measureForwards	boolean: If true, measure forwards, starting at start. Otherwise, measure backwards, starting with end.
maxWidth	float: The maximum width to accumulate.
measuredWidth	float: Optional. If not null, returns the actual width measured.
Returns
int	The number of chars that were measured. Will always be <= abs(end - start).
clearShadowLayer

Added in API level 1
void clearShadowLayer ()
Clear the shadow layer.

descent

Added in API level 1
float descent ()
Return the distance below (positive) the baseline (descent) based on the current typeface and text size.

Returns
float	the distance below (positive) the baseline (descent) based on the current typeface and text size.
getAlpha

Added in API level 1
int getAlpha ()
Helper to getColor() that just returns the color's alpha value. This is the same as calling getColor() >>> 24. It always returns a value between 0 (completely transparent) and 255 (completely opaque).

Returns
int	the alpha component of the paint's color.
getColor

Added in API level 1
int getColor ()
Return the paint's color. Note that the color is a 32bit value containing alpha as well as r,g,b. This 32bit value is not premultiplied, meaning that its alpha can be any value, regardless of the values of r,g,b. See the Color class for more details.

Returns
int	the paint's color (and alpha).
getColorFilter

Added in API level 1
ColorFilter getColorFilter ()
Get the paint's colorfilter (maybe be null).

Returns
ColorFilter	the paint's colorfilter (maybe be null)
getFillPath

Added in API level 1
boolean getFillPath (Path src, 
                Path dst)
Applies any/all effects (patheffect, stroking) to src, returning the result in dst. The result is that drawing src with this paint will be the same as drawing dst with a default paint (at least from the geometric perspective).

Parameters
src	Path: input path
dst	Path: output path (may be the same as src)
Returns
boolean	true if the path should be filled, or false if it should be drawn with a hairline (width == 0)
getFlags

Added in API level 1
int getFlags ()
Return the paint's flags. Use the Flag enum to test flag values.

Returns
int	the paint's flags (see enums ending in _Flag for bit masks)
getFontFeatureSettings

Added in API level 21
String getFontFeatureSettings ()
Returns the font feature settings. The format is the same as the CSS font-feature-settings attribute: http://dev.w3.org/csswg/css-fonts/#propdef-font-feature-settings

Returns
String	the paint's currently set font feature settings. Default is null.
See also:

setFontFeatureSettings(String)
getFontMetrics

Added in API level 1
float getFontMetrics (Paint.FontMetrics metrics)
Return the font's recommended interline spacing, given the Paint's settings for typeface, textSize, etc. If metrics is not null, return the fontmetric values in it.

Parameters
metrics	Paint.FontMetrics: If this object is not null, its fields are filled with the appropriate values given the paint's text attributes.
Returns
float	the font's recommended interline spacing.
getFontMetrics

Added in API level 1
Paint.FontMetrics getFontMetrics ()
Allocates a new FontMetrics object, and then calls getFontMetrics(fm) with it, returning the object.

Returns
Paint.FontMetrics	
getFontMetricsInt

Added in API level 1
int getFontMetricsInt (Paint.FontMetricsInt fmi)
Return the font's interline spacing, given the Paint's settings for typeface, textSize, etc. If metrics is not null, return the fontmetric values in it. Note: all values have been converted to integers from floats, in such a way has to make the answers useful for both spacing and clipping. If you want more control over the rounding, call getFontMetrics().

Parameters
fmi	Paint.FontMetricsInt
Returns
int	the font's interline spacing.
getFontMetricsInt

Added in API level 1
Paint.FontMetricsInt getFontMetricsInt ()
Returns
Paint.FontMetricsInt	
getFontSpacing

Added in API level 1
float getFontSpacing ()
Return the recommend line spacing based on the current typeface and text size.

Returns
float	recommend line spacing based on the current typeface and text size.
getHinting

Added in API level 14
int getHinting ()
Return the paint's hinting mode. Returns either HINTING_OFF or HINTING_ON.

Returns
int	
getLetterSpacing

Added in API level 21
float getLetterSpacing ()
Return the paint's letter-spacing for text. The default value is 0.

Returns
float	the paint's letter-spacing for drawing text.
getMaskFilter

Added in API level 1
MaskFilter getMaskFilter ()
Get the paint's maskfilter object.

Returns
MaskFilter	the paint's maskfilter (or null)
getOffsetForAdvance

Added in API level 23
int getOffsetForAdvance (char[] text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                float advance)
Get the character offset within the string whose position is closest to the specified horizontal position.

The returned value is generally the value of offset for which getRunAdvance(char[], int, int, int, int, boolean, int) yields a result most closely approximating advance, and which is also on a grapheme cluster boundary. As such, it is the preferred method for positioning a cursor in response to a touch or pointer event. The grapheme cluster boundaries are based on Unicode Standard Annex #29 but with some tailoring for better user experience.

Note that advance is a (generally positive) width measurement relative to the start of the run. Thus, for RTL runs it the distance from the point to the right edge.

All indices are relative to the start of text. Further, 0 <= contextStart <= start <= end <= contextEnd <= text.length must hold on entry, and start <= result <= end will hold on return.

Parameters
text	char: the text to measure. Cannot be null.
start	int: the index of the start of the range to measure
end	int: the index + 1 of the end of the range to measure
contextStart	int: the index of the start of the shaping context
contextEnd	int: the index + 1 of the end of the range to measure
isRtl	boolean: whether the run is in RTL direction
advance	float: width relative to start of run
Returns
int	index of offset
getOffsetForAdvance

Added in API level 23
int getOffsetForAdvance (CharSequence text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                float advance)
Parameters
text	CharSequence: the text to measure. Cannot be null.
start	int: the index of the start of the range to measure
end	int: the index + 1 of the end of the range to measure
contextStart	int: the index of the start of the shaping context
contextEnd	int: the index + 1 of the end of the range to measure
isRtl	boolean: whether the run is in RTL direction
advance	float: width relative to start of run
Returns
int	index of offset
See also:

getOffsetForAdvance(char[], int, int, int, int, boolean, float)
getPathEffect

Added in API level 1
PathEffect getPathEffect ()
Get the paint's patheffect object.

Returns
PathEffect	the paint's patheffect (or null)
getRasterizer

Added in API level 1
Rasterizer getRasterizer ()
This method was deprecated in API level 21.
Rasterizer is not supported by either the HW or PDF backends.

Get the paint's rasterizer (or null).

The raster controls/modifies how paths/text are turned into alpha masks.

Returns
Rasterizer	the paint's rasterizer (or null)
getRunAdvance

Added in API level 23
float getRunAdvance (char[] text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                int offset)
Measure cursor position within a run of text.

The run of text includes the characters from start to end in the text. In addition, the range contextStart to contextEnd is used as context for the purpose of complex text shaping, such as Arabic text potentially shaped differently based on the text next to it.

All text outside the range contextStart..contextEnd is ignored. The text between start and end will be laid out to be measured.

The returned width measurement is the advance from start to offset. It is generally a positive value, no matter the direction of the run. If offset == end, the return value is simply the width of the whole run from start to end.

Ligatures are formed for characters in the range start..end (but not for start..contextStart or end..contextEnd). If offset points to a character in the middle of such a formed ligature, but at a grapheme cluster boundary, the return value will also reflect an advance in the middle of the ligature. See getOffsetForAdvance(char[], int, int, int, int, boolean, float) for more discussion of grapheme cluster boundaries.

The direction of the run is explicitly specified by isRtl. Thus, this method is suitable only for runs of a single direction.

All indices are relative to the start of text. Further, 0 <= contextStart <= start <= offset <= end <= contextEnd <= text.length must hold on entry.

Parameters
text	char: the text to measure. Cannot be null.
start	int: the index of the start of the range to measure
end	int: the index + 1 of the end of the range to measure
contextStart	int: the index of the start of the shaping context
contextEnd	int: the index + 1 of the end of the shaping context
isRtl	boolean: whether the run is in RTL direction
offset	int: index of caret position
Returns
float	width measurement between start and offset
getRunAdvance

Added in API level 23
float getRunAdvance (CharSequence text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                int offset)
Parameters
text	CharSequence: the text to measure. Cannot be null.
start	int: the index of the start of the range to measure
end	int: the index + 1 of the end of the range to measure
contextStart	int: the index of the start of the shaping context
contextEnd	int: the index + 1 of the end of the shaping context
isRtl	boolean: whether the run is in RTL direction
offset	int: index of caret position
Returns
float	width measurement between start and offset
See also:

getRunAdvance(char[], int, int, int, int, boolean, int)
getShader

Added in API level 1
Shader getShader ()
Get the paint's shader object.

Returns
Shader	the paint's shader (or null)
getStrokeCap

Added in API level 1
Paint.Cap getStrokeCap ()
Return the paint's Cap, controlling how the start and end of stroked lines and paths are treated.

Returns
Paint.Cap	the line cap style for the paint, used whenever the paint's style is Stroke or StrokeAndFill.
getStrokeJoin

Added in API level 1
Paint.Join getStrokeJoin ()
Return the paint's stroke join type.

Returns
Paint.Join	the paint's Join.
getStrokeMiter

Added in API level 1
float getStrokeMiter ()
Return the paint's stroke miter value. Used to control the behavior of miter joins when the joins angle is sharp.

Returns
float	the paint's miter limit, used whenever the paint's style is Stroke or StrokeAndFill.
getStrokeWidth

Added in API level 1
float getStrokeWidth ()
Return the width for stroking.

A value of 0 strokes in hairline mode. Hairlines always draws a single pixel independent of the canva's matrix.

Returns
float	the paint's stroke width, used whenever the paint's style is Stroke or StrokeAndFill.
getStyle

Added in API level 1
Paint.Style getStyle ()
Return the paint's style, used for controlling how primitives' geometries are interpreted (except for drawBitmap, which always assumes FILL_STYLE).

Returns
Paint.Style	the paint's style setting (Fill, Stroke, StrokeAndFill)
getTextAlign

Added in API level 1
Paint.Align getTextAlign ()
Return the paint's Align value for drawing text. This controls how the text is positioned relative to its origin. LEFT align means that all of the text will be drawn to the right of its origin (i.e. the origin specifieds the LEFT edge of the text) and so on.

Returns
Paint.Align	the paint's Align value for drawing text.
getTextBounds

Added in API level 1
void getTextBounds (String text, 
                int start, 
                int end, 
                Rect bounds)
Return in bounds (allocated by the caller) the smallest rectangle that encloses all of the characters, with an implied origin at (0,0).

Parameters
text	String: String to measure and return its bounds
start	int: Index of the first char in the string to measure
end	int: 1 past the last char in the string measure
bounds	Rect: Returns the unioned bounds of all the text. Must be allocated by the caller.
getTextBounds

Added in API level 1
void getTextBounds (char[] text, 
                int index, 
                int count, 
                Rect bounds)
Return in bounds (allocated by the caller) the smallest rectangle that encloses all of the characters, with an implied origin at (0,0).

Parameters
text	char: Array of chars to measure and return their unioned bounds
index	int: Index of the first char in the array to measure
count	int: The number of chars, beginning at index, to measure
bounds	Rect: Returns the unioned bounds of all the text. Must be allocated by the caller.
getTextLocale

Added in API level 17
Locale getTextLocale ()
Get the text's primary Locale. Note that this is not all of the locale-related information Paint has. Use getTextLocales() to get the complete list.

Returns
Locale	the paint's primary Locale used for drawing text, never null.
getTextLocales

Added in API level 24
LocaleList getTextLocales ()
Get the text locale list.

Returns
LocaleList	the paint's LocaleList used for drawing text, never null or empty.
getTextPath

Added in API level 1
void getTextPath (char[] text, 
                int index, 
                int count, 
                float x, 
                float y, 
                Path path)
Return the path (outline) for the specified text. Note: just like Canvas.drawText, this will respect the Align setting in the paint.

Parameters
text	char: The text to retrieve the path from
index	int: The index of the first character in text
count	int: The number of characterss starting with index
x	float: The x coordinate of the text's origin
y	float: The y coordinate of the text's origin
path	Path: The path to receive the data describing the text. Must be allocated by the caller.
getTextPath

Added in API level 1
void getTextPath (String text, 
                int start, 
                int end, 
                float x, 
                float y, 
                Path path)
Return the path (outline) for the specified text. Note: just like Canvas.drawText, this will respect the Align setting in the paint.

Parameters
text	String: The text to retrieve the path from
start	int: The first character in the text
end	int: 1 past the last charcter in the text
x	float: The x coordinate of the text's origin
y	float: The y coordinate of the text's origin
path	Path: The path to receive the data describing the text. Must be allocated by the caller.
getTextScaleX

Added in API level 1
float getTextScaleX ()
Return the paint's horizontal scale factor for text. The default value is 1.0.

Returns
float	the paint's scale factor in X for drawing/measuring text
getTextSize

Added in API level 1
float getTextSize ()
Return the paint's text size.

Returns
float	the paint's text size.
getTextSkewX

Added in API level 1
float getTextSkewX ()
Return the paint's horizontal skew factor for text. The default value is 0.

Returns
float	the paint's skew factor in X for drawing text.
getTextWidths

Added in API level 1
int getTextWidths (char[] text, 
                int index, 
                int count, 
                float[] widths)
Return the advance widths for the characters in the string.

Parameters
text	char: The text to measure. Cannot be null.
index	int: The index of the first char to to measure
count	int: The number of chars starting with index to measure
widths	float: array to receive the advance widths of the characters. Must be at least a large as count.
Returns
int	the actual number of widths returned.
getTextWidths

Added in API level 1
int getTextWidths (String text, 
                float[] widths)
Return the advance widths for the characters in the string.

Parameters
text	String: The text to measure
widths	float: array to receive the advance widths of the characters. Must be at least a large as the text.
Returns
int	the number of code units in the specified text.
getTextWidths

Added in API level 1
int getTextWidths (String text, 
                int start, 
                int end, 
                float[] widths)
Return the advance widths for the characters in the string.

Parameters
text	String: The text to measure. Cannot be null.
start	int: The index of the first char to to measure
end	int: The end of the text slice to measure
widths	float: array to receive the advance widths of the characters. Must be at least a large as the text.
Returns
int	the number of code units in the specified text.
getTextWidths

Added in API level 1
int getTextWidths (CharSequence text, 
                int start, 
                int end, 
                float[] widths)
Return the advance widths for the characters in the string.

Parameters
text	CharSequence: The text to measure. Cannot be null.
start	int: The index of the first char to to measure
end	int: The end of the text slice to measure
widths	float: array to receive the advance widths of the characters. Must be at least a large as (end - start).
Returns
int	the actual number of widths returned.
getTypeface

Added in API level 1
Typeface getTypeface ()
Get the paint's typeface object.

The typeface object identifies which font to use when drawing or measuring text.

Returns
Typeface	the paint's typeface (or null)
getXfermode

Added in API level 1
Xfermode getXfermode ()
Get the paint's xfermode object.

Returns
Xfermode	the paint's xfermode (or null)
hasGlyph

Added in API level 23
boolean hasGlyph (String string)
Determine whether the typeface set on the paint has a glyph supporting the string. The simplest case is when the string contains a single character, in which this method determines whether the font has the character. In the case of multiple characters, the method returns true if there is a single glyph representing the ligature. For example, if the input is a pair of regional indicator symbols, determine whether there is an emoji flag for the pair.

Finally, if the string contains a variation selector, the method only returns true if the fonts contains a glyph specific to that variation.

Checking is done on the entire fallback chain, not just the immediate font referenced.

Parameters
string	String: the string to test whether there is glyph support
Returns
boolean	true if the typeface has a glyph for the string
isAntiAlias

Added in API level 1
boolean isAntiAlias ()
Helper for getFlags(), returning true if ANTI_ALIAS_FLAG bit is set AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape. See setDither() and setFilterBitmap() to affect how colors are treated.

Returns
boolean	true if the antialias bit is set in the paint's flags.
isDither

Added in API level 1
boolean isDither ()
Helper for getFlags(), returning true if DITHER_FLAG bit is set Dithering affects how colors that are higher precision than the device are down-sampled. No dithering is generally faster, but higher precision colors are just truncated down (e.g. 8888 -> 565). Dithering tries to distribute the error inherent in this process, to reduce the visual artifacts.

Returns
boolean	true if the dithering bit is set in the paint's flags.
isElegantTextHeight

Added in API level 21
boolean isElegantTextHeight ()
Get the elegant metrics flag.

Returns
boolean	true if elegant metrics are enabled for text drawing.
isFakeBoldText

Added in API level 1
boolean isFakeBoldText ()
Helper for getFlags(), returning true if FAKE_BOLD_TEXT_FLAG bit is set

Returns
boolean	true if the fakeBoldText bit is set in the paint's flags.
isFilterBitmap

Added in API level 1
boolean isFilterBitmap ()
Whether or not the bitmap filter is activated. Filtering affects the sampling of bitmaps when they are transformed. Filtering does not affect how the colors in the bitmap are converted into device pixels. That is dependent on dithering and xfermodes.

Returns
boolean	
See also:

setFilterBitmap()
isLinearText

Added in API level 1
boolean isLinearText ()
Helper for getFlags(), returning true if LINEAR_TEXT_FLAG bit is set

Returns
boolean	true if the lineartext bit is set in the paint's flags
isStrikeThruText

Added in API level 1
boolean isStrikeThruText ()
Helper for getFlags(), returning true if STRIKE_THRU_TEXT_FLAG bit is set

Returns
boolean	true if the strikeThruText bit is set in the paint's flags.
isSubpixelText

Added in API level 1
boolean isSubpixelText ()
Helper for getFlags(), returning true if SUBPIXEL_TEXT_FLAG bit is set

Returns
boolean	true if the subpixel bit is set in the paint's flags
isUnderlineText

Added in API level 1
boolean isUnderlineText ()
Helper for getFlags(), returning true if UNDERLINE_TEXT_FLAG bit is set

Returns
boolean	true if the underlineText bit is set in the paint's flags.
measureText

Added in API level 1
float measureText (char[] text, 
                int index, 
                int count)
Return the width of the text.

Parameters
text	char: The text to measure. Cannot be null.
index	int: The index of the first character to start measuring
count	int: THe number of characters to measure, beginning with start
Returns
float	The width of the text
measureText

Added in API level 1
float measureText (CharSequence text, 
                int start, 
                int end)
Return the width of the text.

Parameters
text	CharSequence: The text to measure
start	int: The index of the first character to start measuring
end	int: 1 beyond the index of the last character to measure
Returns
float	The width of the text
measureText

Added in API level 1
float measureText (String text, 
                int start, 
                int end)
Return the width of the text.

Parameters
text	String: The text to measure. Cannot be null.
start	int: The index of the first character to start measuring
end	int: 1 beyond the index of the last character to measure
Returns
float	The width of the text
measureText

Added in API level 1
float measureText (String text)
Return the width of the text.

Parameters
text	String: The text to measure. Cannot be null.
Returns
float	The width of the text
reset

Added in API level 1
void reset ()
Restores the paint to its default settings.

set

Added in API level 1
void set (Paint src)
Copy the fields from src into this paint. This is equivalent to calling get() on all of the src fields, and calling the corresponding set() methods on this.

Parameters
src	Paint
setARGB

Added in API level 1
void setARGB (int a, 
                int r, 
                int g, 
                int b)
Helper to setColor(), that takes a,r,g,b and constructs the color int

Parameters
a	int: The new alpha component (0..255) of the paint's color.
r	int: The new red component (0..255) of the paint's color.
g	int: The new green component (0..255) of the paint's color.
b	int: The new blue component (0..255) of the paint's color.
setAlpha

Added in API level 1
void setAlpha (int a)
Helper to setColor(), that only assigns the color's alpha value, leaving its r,g,b values unchanged. Results are undefined if the alpha value is outside of the range [0..255]

Parameters
a	int: set the alpha component [0..255] of the paint's color.
setAntiAlias

Added in API level 1
void setAntiAlias (boolean aa)
Helper for setFlags(), setting or clearing the ANTI_ALIAS_FLAG bit AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape. See setDither() and setFilterBitmap() to affect how colors are treated.

Parameters
aa	boolean: true to set the antialias bit in the flags, false to clear it
setColor

Added in API level 1
void setColor (int color)
Set the paint's color. Note that the color is an int containing alpha as well as r,g,b. This 32bit value is not premultiplied, meaning that its alpha can be any value, regardless of the values of r,g,b. See the Color class for more details.

Parameters
color	int: The new color (including alpha) to set in the paint.
setColorFilter

Added in API level 1
ColorFilter setColorFilter (ColorFilter filter)
Set or clear the paint's colorfilter, returning the parameter.

Parameters
filter	ColorFilter: May be null. The new filter to be installed in the paint
Returns
ColorFilter	filter
setDither

Added in API level 1
void setDither (boolean dither)
Helper for setFlags(), setting or clearing the DITHER_FLAG bit Dithering affects how colors that are higher precision than the device are down-sampled. No dithering is generally faster, but higher precision colors are just truncated down (e.g. 8888 -> 565). Dithering tries to distribute the error inherent in this process, to reduce the visual artifacts.

Parameters
dither	boolean: true to set the dithering bit in flags, false to clear it
setElegantTextHeight

Added in API level 21
void setElegantTextHeight (boolean elegant)
Set the paint's elegant height metrics flag. This setting selects font variants that have not been compacted to fit Latin-based vertical metrics, and also increases top and bottom bounds to provide more space.

Parameters
elegant	boolean: set the paint's elegant metrics flag for drawing text.
setFakeBoldText

Added in API level 1
void setFakeBoldText (boolean fakeBoldText)
Helper for setFlags(), setting or clearing the FAKE_BOLD_TEXT_FLAG bit

Parameters
fakeBoldText	boolean: true to set the fakeBoldText bit in the paint's flags, false to clear it.
setFilterBitmap

Added in API level 1
void setFilterBitmap (boolean filter)
Helper for setFlags(), setting or clearing the FILTER_BITMAP_FLAG bit. Filtering affects the sampling of bitmaps when they are transformed. Filtering does not affect how the colors in the bitmap are converted into device pixels. That is dependent on dithering and xfermodes.

Parameters
filter	boolean: true to set the FILTER_BITMAP_FLAG bit in the paint's flags, false to clear it.
setFlags

Added in API level 1
void setFlags (int flags)
Set the paint's flags. Use the Flag enum to specific flag values.

Parameters
flags	int: The new flag bits for the paint
setFontFeatureSettings

Added in API level 21
void setFontFeatureSettings (String settings)
Set font feature settings. The format is the same as the CSS font-feature-settings attribute: http://dev.w3.org/csswg/css-fonts/#propdef-font-feature-settings

Parameters
settings	String: the font feature settings string to use, may be null.
See also:

getFontFeatureSettings()
setHinting

Added in API level 14
void setHinting (int mode)
Set the paint's hinting mode. May be either HINTING_OFF or HINTING_ON.

Parameters
mode	int
setLetterSpacing

Added in API level 21
void setLetterSpacing (float letterSpacing)
Set the paint's letter-spacing for text. The default value is 0. The value is in 'EM' units. Typical values for slight expansion will be around 0.05. Negative values tighten text.

Parameters
letterSpacing	float: set the paint's letter-spacing for drawing text.
setLinearText

Added in API level 1
void setLinearText (boolean linearText)
Helper for setFlags(), setting or clearing the LINEAR_TEXT_FLAG bit

Parameters
linearText	boolean: true to set the linearText bit in the paint's flags, false to clear it.
setMaskFilter

Added in API level 1
MaskFilter setMaskFilter (MaskFilter maskfilter)
Set or clear the maskfilter object.

Pass null to clear any previous maskfilter. As a convenience, the parameter passed is also returned.

Parameters
maskfilter	MaskFilter: May be null. The maskfilter to be installed in the paint
Returns
MaskFilter	maskfilter
setPathEffect

Added in API level 1
PathEffect setPathEffect (PathEffect effect)
Set or clear the patheffect object.

Pass null to clear any previous patheffect. As a convenience, the parameter passed is also returned.

Parameters
effect	PathEffect: May be null. The patheffect to be installed in the paint
Returns
PathEffect	effect
setRasterizer

Added in API level 1
Rasterizer setRasterizer (Rasterizer rasterizer)
This method was deprecated in API level 21.
Rasterizer is not supported by either the HW or PDF backends.

Set or clear the rasterizer object.

Pass null to clear any previous rasterizer. As a convenience, the parameter passed is also returned.

Parameters
rasterizer	Rasterizer: May be null. The new rasterizer to be installed in the paint.
Returns
Rasterizer	rasterizer
setShader

Added in API level 1
Shader setShader (Shader shader)
Set or clear the shader object.

Pass null to clear any previous shader. As a convenience, the parameter passed is also returned.

Parameters
shader	Shader: May be null. the new shader to be installed in the paint
Returns
Shader	shader
setShadowLayer

Added in API level 1
void setShadowLayer (float radius, 
                float dx, 
                float dy, 
                int shadowColor)
This draws a shadow layer below the main layer, with the specified offset and color, and blur radius. If radius is 0, then the shadow layer is removed.

Can be used to create a blurred shadow underneath text. Support for use with other drawing operations is constrained to the software rendering pipeline.

The alpha of the shadow will be the paint's alpha if the shadow color is opaque, or the alpha from the shadow color if not.

Parameters
radius	float
dx	float
dy	float
shadowColor	int
setStrikeThruText

Added in API level 1
void setStrikeThruText (boolean strikeThruText)
Helper for setFlags(), setting or clearing the STRIKE_THRU_TEXT_FLAG bit

Parameters
strikeThruText	boolean: true to set the strikeThruText bit in the paint's flags, false to clear it.
setStrokeCap

Added in API level 1
void setStrokeCap (Paint.Cap cap)
Set the paint's Cap.

Parameters
cap	Paint.Cap: set the paint's line cap style, used whenever the paint's style is Stroke or StrokeAndFill.
setStrokeJoin

Added in API level 1
void setStrokeJoin (Paint.Join join)
Set the paint's Join.

Parameters
join	Paint.Join: set the paint's Join, used whenever the paint's style is Stroke or StrokeAndFill.
setStrokeMiter

Added in API level 1
void setStrokeMiter (float miter)
Set the paint's stroke miter value. This is used to control the behavior of miter joins when the joins angle is sharp. This value must be >= 0.

Parameters
miter	float: set the miter limit on the paint, used whenever the paint's style is Stroke or StrokeAndFill.
setStrokeWidth

Added in API level 1
void setStrokeWidth (float width)
Set the width for stroking. Pass 0 to stroke in hairline mode. Hairlines always draws a single pixel independent of the canva's matrix.

Parameters
width	float: set the paint's stroke width, used whenever the paint's style is Stroke or StrokeAndFill.
setStyle

Added in API level 1
void setStyle (Paint.Style style)
Set the paint's style, used for controlling how primitives' geometries are interpreted (except for drawBitmap, which always assumes Fill).

Parameters
style	Paint.Style: The new style to set in the paint
setSubpixelText

Added in API level 1
void setSubpixelText (boolean subpixelText)
Helper for setFlags(), setting or clearing the SUBPIXEL_TEXT_FLAG bit

Parameters
subpixelText	boolean: true to set the subpixelText bit in the paint's flags, false to clear it.
setTextAlign

Added in API level 1
void setTextAlign (Paint.Align align)
Set the paint's text alignment. This controls how the text is positioned relative to its origin. LEFT align means that all of the text will be drawn to the right of its origin (i.e. the origin specifieds the LEFT edge of the text) and so on.

Parameters
align	Paint.Align: set the paint's Align value for drawing text.
setTextLocale

Added in API level 17
void setTextLocale (Locale locale)
Set the text locale list to a one-member list consisting of just the locale. See setTextLocales(LocaleList) for how the locale list affects the way the text is drawn for some languages.

Parameters
locale	Locale: the paint's locale value for drawing text, must not be null.
setTextLocales

Added in API level 24
void setTextLocales (LocaleList locales)
Set the text locale list. The text locale list affects how the text is drawn for some languages. For example, if the locale list contains CHINESE or CHINA, then the text renderer will prefer to draw text using a Chinese font. Likewise, if the locale list contains JAPANESE or JAPAN, then the text renderer will prefer to draw text using a Japanese font. If the locale list contains both, the order those locales appear in the list is considered for deciding the font. This distinction is important because Chinese and Japanese text both use many of the same Unicode code points but their appearance is subtly different for each language. By default, the text locale list is initialized to a one-member list just containing the system locales. This assumes that the text to be rendered will most likely be in the user's preferred language. If the actual language or languages of the text is/are known, then they can be provided to the text renderer using this method. The text renderer may attempt to guess the language script based on the contents of the text to be drawn independent of the text locale here. Specifying the text locales just helps it do a better job in certain ambiguous cases.

Parameters
locales	LocaleList: the paint's locale list for drawing text, must not be null or empty.
setTextScaleX

Added in API level 1
void setTextScaleX (float scaleX)
Set the paint's horizontal scale factor for text. The default value is 1.0. Values > 1.0 will stretch the text wider. Values < 1.0 will stretch the text narrower.

Parameters
scaleX	float: set the paint's scale in X for drawing/measuring text.
setTextSize

Added in API level 1
void setTextSize (float textSize)
Set the paint's text size. This value must be > 0

Parameters
textSize	float: set the paint's text size.
setTextSkewX

Added in API level 1
void setTextSkewX (float skewX)
Set the paint's horizontal skew factor for text. The default value is 0. For approximating oblique text, use values around -0.25.

Parameters
skewX	float: set the paint's skew factor in X for drawing text.
setTypeface

Added in API level 1
Typeface setTypeface (Typeface typeface)
Set or clear the typeface object.

Pass null to clear any previous typeface. As a convenience, the parameter passed is also returned.

Parameters
typeface	Typeface: May be null. The typeface to be installed in the paint
Returns
Typeface	typeface
setUnderlineText

Added in API level 1
void setUnderlineText (boolean underlineText)
Helper for setFlags(), setting or clearing the UNDERLINE_TEXT_FLAG bit

Parameters
underlineText	boolean: true to set the underlineText bit in the paint's flags, false to clear it.
setXfermode

Added in API level 1
Xfermode setXfermode (Xfermode xfermode)
Set or clear the xfermode object.

Pass null to clear any previous xfermode. As a convenience, the parameter passed is also returned.

Parameters
xfermode	Xfermode: May be null. The xfermode to be installed in the paint
Returns
Xfermode	xfermode
