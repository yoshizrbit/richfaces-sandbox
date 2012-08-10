(function($) {
    $.widget("rf.multicomplete", $.extend({}, $.ui.autocomplete.prototype, {
        
        options: {
            suggestions: [],
            autofill: false,
            tokens: ",",
            
            source: function(request, response) {
                var searchTerm = this._extractLastToken(request.term);
                response( this.options.suggest.call(this, searchTerm) );
            },
            suggest: function(term) {
                var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex(term), "i" );
                return $.grep( this.options.suggestions, function(value) {
                    return matcher.test( value.label || value.value || value );
                });
            }
        },
    
        _create : function() {
            // extend jQuery UI Autocomplete
            $.ui.autocomplete.prototype._create.apply(this, arguments);
            
            var self = this;
            
            $(this.element).on("autocompletefocus", function( event, ui ) {
                if (!self.options.autofill) {
                    // do nothing on suggestion focus
                    return false;
                } else {
                    var terms = self._tokenize( this.value );
                    // remove the current input
                    var lastTerm = terms.pop();
                    var lastTermCompletion = lastTerm + ui.item.value.substring(lastTerm.length);
                    terms.push(lastTermCompletion);
                    
                    var firstToken = self.options.tokens.charAt(0);
                    this.value = terms.join( firstToken == " " ? " " : firstToken + " " );
                    this.setSelectionRange(this.value.length - ui.item.value.length + lastTerm.length, this.value.length);
                    return false;
                }
            });
            
            $(this.element).on("autocompleteselect", function( event, ui ) {
                var terms = self._tokenize( this.value );
                // remove the current input
                terms.pop();
                // add the selected item
                terms.push( ui.item.value );
                // add placeholder to get the comma-and-space at the end
                terms.push( "" );
                var firstToken = self.options.tokens.charAt(0);
                this.value = terms.join( firstToken == " " ? " " : firstToken + " " );
                return false;
            });
        },
        
        _tokenize: function(term) {
            return term.split( new RegExp("\\s*[" + this.options.tokens + "]\\s*") );
        },
        
        _extractLastToken: function(term) {
            return this._tokenize(term).pop();
        }
        
    }));

    $.rf.multicomplete.prototype.options = $.extend({}, $.ui.autocomplete.prototype.options, $.rf.multicomplete.prototype.options);
    
    
})(jQuery);